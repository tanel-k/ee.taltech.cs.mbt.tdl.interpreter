package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin;

import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.PickleGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Mojo(name = "pickle", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class PickleMojo extends AbstractMojo {
	@Parameter(alias = "package", defaultValue = "pickles", readonly = true)
	private String picklePackage;

	@Parameter(alias ="class", defaultValue = "Pickle", readonly = true)
	private String pickleClassName;

	@Parameter(required = true, readonly = true)
	private File sourceFile;

	@Parameter(required = true)
	private File outputDirectory;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		UtaSystem sourceSystem;
		try (InputStream in = new FileInputStream(sourceFile)) {
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
		getLog().info("Generating source code for pickle class.");

		String pickleClass;
		try {
			pickleClass = PickleGeneratorFactory.systemGenerator(picklePackage, pickleClassName)
					.generate(sourceSystem);
		} catch (GenerationException ex) {
			throw new MojoExecutionException("Failed to generate pickle class.", ex);
		}

		getLog().info("Successfully generated source code for pickle class.");

		// TODO: Store in targetDir with name pickleClassName.
		// TODO: Consider package picklePackage as well.
	}
}
