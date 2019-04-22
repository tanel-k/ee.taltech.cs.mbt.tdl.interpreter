package ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli;

import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.Optional;

public class TdlCommandLineOptions {
	@Option(name = "-h", aliases = "--help", usage = "Print help information.", help = true)
	private boolean printHelpMessage;
	@Option(name = "-e", aliases = "--expression", required = true, usage = "Test specification TDL expression.")
	private String expression;
	@Option(name = "-m", aliases = "--model", required = true, usage = "Uppaal SUT model file path.")
	private File modelFile;
	@Option(name = "-v", aliases = "--verbose", usage = "Toggles verbose output.")
	private boolean verbose;
	@Option(name = "-t", aliases = "--traces", usage = "Toggles error trace printing.")
	private boolean tracePrintingEnabled;
	@Option(name = "-o", aliases = "--output", usage = "Output project file path.")
	private File outputFile;
	@Option(name = "-u", aliases = "--uppaal", usage = "Path to Uppaal JAR.", depends = "-o")
	private File uppaalJar;

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

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
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

	public Optional<File> getUppaalJar() {
		return Optional.ofNullable(uppaalJar);
	}

	public void setUppaalJar(File uppaalJar) {
		this.uppaalJar = uppaalJar;
	}
}
