package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.SystemPickleGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mojo(name = "pickle", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class SystemPicklerMojo extends AbstractMojo {
	private static Path packageToPath(String packageString) {
		Matcher m = Pattern.compile("^.*?\\.").matcher(packageString);
		if (!m.find()) {
			// Just a string:
			return Paths.get(packageString);
		}
		String first = m.group();
		first = first.substring(0, first.length() - 1); // Trim last "."
		// Split the rest:
		String[] rest = m.replaceFirst("").split("\\.");
		return Paths.get(first, rest);
	}

	private static final Set<PosixFilePermission> POSIX_READ_ONLY_PERMS = Collections.unmodifiableSet(CollectionUtils.newSet(
			PosixFilePermission.OTHERS_READ,
			PosixFilePermission.OTHERS_EXECUTE,
			PosixFilePermission.OWNER_WRITE
	));
	private static final Set<PosixFilePermission> POSIX_WRITE_PERMS = Collections.unmodifiableSet(CollectionUtils.newSet(
			PosixFilePermission.OTHERS_READ,
			PosixFilePermission.OTHERS_EXECUTE,
			PosixFilePermission.OTHERS_WRITE
	));

	private static void setReadOnly(Path filePath, boolean readOnly) throws IOException {
		FileStore fileStore = Files.getFileStore(filePath);

		if (fileStore.supportsFileAttributeView(DosFileAttributeView.class)) {
			DosFileAttributeView dosView = Files.getFileAttributeView(filePath, DosFileAttributeView.class);
			dosView.setReadOnly(readOnly);
		} else if (fileStore.supportsFileAttributeView(PosixFileAttributeView.class)) {
			PosixFileAttributeView posixView = Files.getFileAttributeView(filePath, PosixFileAttributeView.class);
			posixView.setPermissions(readOnly ? POSIX_READ_ONLY_PERMS : POSIX_WRITE_PERMS);
		}
	}

	@Parameter(defaultValue = "false", readonly = true)
	private Boolean readOnly;

	@Parameter(defaultValue = "pickles", readonly = true)
	private String picklePackage;

	@Parameter(defaultValue = "Pickle", readonly = true)
	private String pickleName;

	@Parameter(required = true, readonly = true)
	private File sourceFile;

	@Parameter(required = true)
	private File outputDirectory;

	@Override
	public void execute() throws MojoExecutionException {
		UtaSystem sourceSystem;
		try (InputStream in = new FileInputStream(sourceFile)) {
			getLog().info("Parsing source project: " + sourceFile.getName());
			sourceSystem = UtaParser.newInstance().parse(in);
		} catch (FileNotFoundException ex) {
			throw new MojoExecutionException("Source project missing.", ex);
		} catch (IOException ex) {
			throw new MojoExecutionException("Exception occurred while reading source project.", ex);
		} catch (MarshallingException ex) {
			throw new MojoExecutionException("Exception occurred while unmarshalling source project.", ex);
		} catch (EmbeddedCodeSyntaxException ex) {
			throw new MojoExecutionException("Source project has syntax errors in embedded code.", ex);
		} catch (InvalidSystemStructureException ex) {
			throw new MojoExecutionException("Source project has structural errors.", ex);
		} catch (Throwable t) {
			throw new MojoExecutionException("Unexpected error while parsing source project.", t);
		}

		getLog().info("Successfully parsed source project.");

		String pickleClassName;
		try {
			getLog().info("Generating class name for pickle factory.");
			pickleClassName = SystemPickleGeneratorFactory.factoryClassNameGenerator()
					.generate(pickleName);
			getLog().info("Pickle factory class name is " + pickleClassName + ".");
		} catch (GenerationException ex) {
			throw new MojoExecutionException("Failed to generate a class name for the pickle class.", ex);
		}

		String pickleClass;
		try {
			getLog().info("Generating source code for " + pickleClassName + ".");
			pickleClass = SystemPickleGeneratorFactory.systemGenerator(picklePackage, pickleName)
					.generate(sourceSystem);
		} catch (GenerationException ex) {
			throw new MojoExecutionException("Failed to generate source code.", ex);
		}

		getLog().info("Source code generation successful.");

		String formattedPickleClass = pickleClass;
		try {
			getLog().info("Attempting to format source code.");
			formattedPickleClass = new Formatter().formatSource(formattedPickleClass);
			getLog().info("Successfully formatted source code.");
		} catch (FormatterException ex) {
			getLog().warn("Failed to format source code.", ex);
		}

		Path packagePath = packageToPath(picklePackage).resolve(Paths.get(pickleClassName + ".java"));
		Path outputFilePath = outputDirectory.toPath().resolve(packagePath);
		try {
			if (Files.notExists(outputFilePath.getParent())) {
				getLog().info("Setting up file directory " + outputFilePath.getParent().getFileName());
				Files.createDirectories(outputFilePath.getParent());
			}

			if (Files.notExists(outputFilePath)) {
				getLog().info("Setting up file " + outputFilePath.getFileName());
				outputFilePath = Files.createFile(outputFilePath);
			} else if (!Files.isWritable(outputFilePath)) {
				getLog().info("Removing read-only restriction from " + outputFilePath.getFileName() + ".");
				setReadOnly(outputFilePath, false);
			}
		} catch (Throwable t) {
			throw new MojoExecutionException("Failed to set up file path.", t);
		}

		File outputFile;
		try (FileOutputStream out = new FileOutputStream(outputFile = outputFilePath.toFile())) {
			getLog().info("Writing to " + outputFilePath.toString());
			out.write(formattedPickleClass.getBytes());
		} catch (Throwable t) {
			throw new MojoExecutionException("Failed to write pickle class file.", t);
		}

		if (readOnly) {
			try {
				setReadOnly(outputFilePath, true);
			} catch (IOException ex) {
				getLog().warn("Failed to set read only permissions for pickle class file.", ex);
			}
		}
	}
}
