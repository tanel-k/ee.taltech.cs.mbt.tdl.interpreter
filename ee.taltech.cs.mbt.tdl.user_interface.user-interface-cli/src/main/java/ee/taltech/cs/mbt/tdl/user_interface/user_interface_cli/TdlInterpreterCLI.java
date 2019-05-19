package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config.TdlCommandLineOptions;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config.custom_options.StringOrFile;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.listeners.PrintingErrorListener;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.listeners.PrintingProgressListener;
import ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.TdlInterpreterUI;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

	private static void printUsageError(CmdLineException ex) {
		err.println(ex.getLocalizedMessage());
		err.println();
		printHelp(err);
	}

	private static Optional<FileInputStream> getFileInputStream(File file) {
		try {
			return Optional.of(new FileInputStream(file));
		} catch (FileNotFoundException ex) {
			err.println("ERROR: " + file.getAbsolutePath() + " not found.");
			System.exit(EReturnStatus.FILE_NOT_FOUND.value());
			return Optional.empty(); // Formality.
		}
	}

	private static void executeInterpretation(TdlCommandLineOptions options) {
		boolean verbose = options.isVerbose();
		boolean tracesEnabled = options.isTracePrintingEnabled();
		StringOrFile exprStrOrFile = options.getExpression();
		File modelFile = options.getModelFile();
		Optional<File> optOutputFile = options.getOutputFile();
		Optional<File> optUppaalJARFile = options.getUppaalJAR();

		OutputStream outStream;
		ByteArrayOutputStream byteArrOutStream = null;
		if (!optOutputFile.isPresent()) {
			// Prevent chatter when outputting to std stream.
			verbose = false;
			outStream = out;
		} else {
			// Write into byte array so that we don't get an empty file when interpretation fails.
			byteArrOutStream = new ByteArrayOutputStream();
			outStream = byteArrOutStream;
		}

		Flag completionFlag = Flag.newInstance();
		PrintingErrorListener errorListener = new PrintingErrorListener(
				tracesEnabled,
				err,
				(s) -> System.exit(s.value())
		);
		PrintingProgressListener progressListener = new PrintingProgressListener(
				verbose ? out : null,
				err,
				completionFlag
		);

		InputStream sutModelStream;
		Optional<FileInputStream> optSutModelStream = getFileInputStream(modelFile);
		if (!optSutModelStream.isPresent()) {
			return;
		} else {
			sutModelStream = optSutModelStream.get();
		}

		InputStream expressionStream;
		Optional<File> optExprFile = exprStrOrFile.getFile();
		if (optExprFile.isPresent()) {
			File exprFile = optExprFile.get();
			Optional<FileInputStream> optExpressionStream = getFileInputStream(exprFile);
			if (!optExpressionStream.isPresent()) {
				return;
			} else {
				expressionStream = optExpressionStream.get();
			}
		} else {
			expressionStream = new ByteArrayInputStream(exprStrOrFile.getString().getBytes());
		}

		TdlInterpreterUI tdlInterpreterUI = TdlInterpreterUI
				.getInstance(errorListener, progressListener);

		tdlInterpreterUI.interpret(sutModelStream, expressionStream, outStream);

		File outputFile = null;
		if (byteArrOutStream != null) {
			outputFile = optOutputFile.get();
			try (FileOutputStream fileOut = new FileOutputStream(outputFile)) {
				fileOut.write(byteArrOutStream.toByteArray());
			} catch (IOException ex) {
				err.println("ERROR: Failed to write to " + outputFile.getAbsolutePath() + ".");

				if (tracesEnabled)
					ex.printStackTrace(err);

				System.exit(EReturnStatus.FILE_WRITE_ERROR.value());
				return; // Formality.
			}
		}

		if (outputFile != null && completionFlag.isSet() && optUppaalJARFile.isPresent()) {
			/*
			 * Note:
			 * UPPAAL will generate a file named 'license.txt' some where near the working directory.
			 * This happens after it launches.
			 * Fixing this (tiny) issue is out of scope.
			 */
			File uppaalJARFile = optUppaalJARFile.get();
			try {
				String command = String.format(
						"\"%s\\bin\\java.exe\" -jar \"%s\" \"%s\"",
						System.getProperty("java.home"),
						uppaalJARFile.getAbsoluteFile(),
						outputFile.getAbsolutePath()
				);
				out.println("Starting UPPAAL with command: " + command);
				Runtime.getRuntime().exec(command);
			} catch (Throwable t) {
				err.println("ERROR: Cannot send command to Uppaal JAR.");

				if (tracesEnabled)
					t.printStackTrace(err);

				System.exit(EReturnStatus.UPPAAL_RUN_FAILURE.value());
				return; // Formality.
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
				printUsageError(ex);
				System.exit(EReturnStatus.INVALID_ARGUMENTS.value());
				return; // Formality.
			}

			if (options.isPrintHelpMessage()) {
				printHelp();

				// Check whether only the -h|--help option was provided:
				if (ObjectUtils.isAnyNull(options.getExpression(), options.getModelFile()))
					return;
			}

			executeInterpretation(options);
		}

		System.exit(EReturnStatus.SUCCESS.value());
	}
}
