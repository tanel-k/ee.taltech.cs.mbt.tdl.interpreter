package ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli.interpretation_listeners.PrintingErrorListener;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli.interpretation_listeners.PrintingProgressListener;
import ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.TdlInterpreter;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static java.lang.System.err;
import static java.lang.System.out;

public class TdlInterpreterCLI {
	private static void printHelp() {
		printHelp(out);
	}

	private static void printHelp(PrintStream outStream) {
		// Workaround: use new options inst to prevent outputting invalid default values (args4j bug #153).
		CmdLineParser argParser = new CmdLineParser(new TdlCommandLineOptions());
		outStream.println("TDL(TP) Interpreter Usage:");
		argParser.printSingleLineUsage(outStream);
		outStream.println();
		outStream.println();
		outStream.println("Parameters:");
		argParser.printUsage(outStream);
	}

	private static void printUsageError(CmdLineException ex, CmdLineParser argParser) {
		err.println(ex.getLocalizedMessage());
		err.println();
		printHelp(err);
	}

	private static void printMissingFileError(File modelFile) {
		err.println("ERROR: " + modelFile.getAbsolutePath() + " not found.");
		printHelp(err);
	}

	private static void interpret(TdlCommandLineOptions options) {
		boolean verbose = options.isVerbose();
		boolean tracesEnabled = options.isTracePrintingEnabled();
		String expression = options.getExpression();
		File modelFile = options.getModelFile();

		Optional<File> optOutputFile = options.getOutputFile();
		Optional<File> optUppaalJarFile = options.getUppaalJar();

		OutputStream outStream;
		File outputFile = null;
		if (optOutputFile.isPresent()) {
			outputFile = optOutputFile.get();
			try
			{
				outStream = new FileOutputStream(outputFile);
			} catch (FileNotFoundException ex) {
				printMissingFileError(outputFile);
				System.exit(EReturnStatus.FILE_NOT_FOUND.value());
				return; // Formality.
			}
		} else {
			// We will send results to std out; prevent outputting chatter.
			verbose = false;
			outStream = out;
		}

		Flag completionFlag = Flag.newInstance();
		PrintingErrorListener errorListener = new PrintingErrorListener(
				tracesEnabled,
				err,
				(s) -> System.exit(s.value())
		);
		PrintingProgressListener progressListener = new PrintingProgressListener(
				verbose ? out : null,
				completionFlag
		);

		FileInputStream sutModelStream;
		try {
			sutModelStream = new FileInputStream(modelFile);
		} catch (FileNotFoundException ex) {
			printMissingFileError(modelFile);
			System.exit(EReturnStatus.FILE_NOT_FOUND.value());
			return; // Formality.
		}

		ByteArrayInputStream expressionStream = new ByteArrayInputStream(expression.getBytes());

		TdlInterpreter tdlInterpreter = TdlInterpreter
				.getInstance(errorListener, progressListener);

		tdlInterpreter.interpret(sutModelStream, expressionStream, outStream);

		// FIXME: Remove file produced by outStream on fail.
		if (completionFlag.isSet() && optUppaalJarFile.isPresent()) {
			File uppaalJarFile = optUppaalJarFile.get();
			if (outputFile != null && outputFile.exists()) {
				try {
					String command = String.format(
						"java -jar \"%s\" \"%s\"",
						uppaalJarFile.getAbsoluteFile(),
						outputFile.getAbsolutePath()
					);
					Runtime.getRuntime().exec(command);
				} catch (IOException ex) {
					err.println("ERROR: Cannot send command to Uppaal JAR: " + ex.getClass().getSimpleName() + ".");
					if (tracesEnabled)
						ex.printStackTrace(err);
					System.exit(EReturnStatus.UPPAAL_RUN_FAILURE.value());
					return; // Formality.
				}
			}
		}

		System.exit(EReturnStatus.SUCCESS.value());
	}

	public static void main(final String... args) {
		TdlCommandLineOptions options = new TdlCommandLineOptions();
		CmdLineParser argParser = new CmdLineParser(options);

		if (args.length == 0) {
			printHelp();
		} else {
			try {
				argParser.parseArgument(args);
			} catch (CmdLineException ex) {
				printUsageError(ex, argParser);
				System.exit(EReturnStatus.INVALID_ARGUMENTS.value());
				// Formality:
				return;
			}

			if (options.isPrintHelpMessage()) {
				printHelp();

				// Check whether only the -h|--help option was provided:
				if (ObjectUtils.isAnyNull(options.getExpression(), options.getModelFile()))
					return;
			}

			interpret(options);
		}

		System.exit(EReturnStatus.SUCCESS.value());
	}
}
