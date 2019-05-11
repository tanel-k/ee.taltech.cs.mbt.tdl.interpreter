package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config;

import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config.custom_options.StringOrFile;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config.custom_options.StringOrFileHandler;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.Optional;

public class TdlCommandLineOptions {
	@Option(
			name = "-h",
			aliases = "--help",
			usage = "Print usage information.",
			metaVar = "<NONE>",
			help = true
	) private boolean printHelpMessage;
	@Option(
			name = "-e",
			aliases = "--expression",
			required = true,
			handler = StringOrFileHandler.class,
			metaVar = "STRING|FILE",
			usage = "Test specification TDL expression."
	) private StringOrFile expression;
	@Option(
			name = "-m",
			aliases = "--model",
			required = true,
			metaVar = "FILE",
			usage = "UPPAAL SUT model file path."
	) private File modelFile;
	@Option(
			name = "-v",
			aliases = "--verbose",
			metaVar = "<NONE>",
			usage = "Enables verbosity (unless streaming to std output)."
	) private boolean verbose;
	@Option(
			name = "-t",
			aliases = "--traces",
			metaVar = "<NONE>",
			usage = "Enables error trace printing."
	) private boolean tracePrintingEnabled;
	@Option(
			name = "-o",
			aliases = "--output",
			metaVar = "FILE",
			usage = "File path for storing the resulting UPPAAL model. When omitted, results are pushed to std output and verbosity is disabled."
	) private File outputFile;
	@Option(
			name = "-u",
			aliases = "--uppaal",
			metaVar = "FILE",
			usage = "Path to UPPAAL JAR. When -o|--output is available, used to open the result model in UPPAAL.",
			depends = "-o"
	) private File uppaalJAR;

	public boolean isPrintHelpMessage() {
		return printHelpMessage;
	}

	public void setPrintHelpMessage(boolean printHelpMessage) {
		this.printHelpMessage = printHelpMessage;
	}

	public boolean isTracePrintingEnabled() {
		return tracePrintingEnabled;
	}

	public void setTracePrintingEnabled(boolean tracePrintingEnabled) {
		this.tracePrintingEnabled = tracePrintingEnabled;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public StringOrFile getExpression() {
		return expression;
	}

	public void setExpression(StringOrFile expression) {
		this.expression = expression;
	}

	public File getModelFile() {
		return modelFile;
	}

	public void setModelFile(File modelFile) {
		this.modelFile = modelFile;
	}

	public Optional<File> getOutputFile() {
		return Optional.ofNullable(outputFile);
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public Optional<File> getUppaalJAR() {
		return Optional.ofNullable(uppaalJAR);
	}

	public void setUppaalJAR(File uppaalJAR) {
		this.uppaalJAR = uppaalJAR;
	}
}
