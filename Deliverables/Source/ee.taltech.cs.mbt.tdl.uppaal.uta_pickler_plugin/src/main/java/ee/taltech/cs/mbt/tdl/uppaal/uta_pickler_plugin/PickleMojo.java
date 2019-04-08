package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin;

import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Mojo(name = "pickle")
public class PickleMojo extends AbstractMojo {
	@Parameter(alias = "package")
	private String packageName;

	@Parameter(required = true, readonly = true)
	private File sourceFile;

	@Parameter(required = true)
	private File outputDirectory;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		UtaSystem sourceSystem = null;
		try (InputStream in = new FileInputStream(sourceFile)) {
			sourceSystem = UtaParser.newInstance().parse(in);
		} catch (FileNotFoundException ex) {
			getLog().error("Source project missing.", ex);
		} catch (IOException ex) {
			getLog().error("Exception occurred while reading source project.", ex);
		} catch (MarshallingException ex) {
			getLog().error("Exception occurred while unmarshalling source project.", ex);
		} catch (EmbeddedCodeSyntaxException ex) {
			getLog().error("Source project has syntax errors in embedded code.", ex);
		} catch (InvalidSystemStructureException ex) {
			getLog().error("Source project has structural errors.", ex);
		}

		if (sourceSystem == null)
			return;

		getLog().info("Todo");
	}
}
