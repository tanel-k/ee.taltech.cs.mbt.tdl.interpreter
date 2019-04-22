package ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli;

import static java.lang.System.out;
import static java.lang.System.err;

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
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Optional;

public class TdlInterpreterCLI {
	private static void printHelp(CmdLineParser argParser, PrintStream outStream) {
		outStream.println("TDL(TP) Interpreter Usage:");
		argParser.printSingleLineUsage(outStream);
		outStream.println();
		outStream.println();
		outStream.println("Parameters:");
		argParser.printUsage(outStream);
	}

	private static void printHelp(CmdLineParser argParser) {
		printHelp(argParser, out);
	}

	private static void printUsageError(CmdLineException ex, CmdLineParser argParser) {
		err.println(ex.getLocalizedMessage());
		err.println();
		printHelp(argParser, err);
	}

	private static void interpret(TdlCommandLineOptions options) {
		boolean verbose = options.isVerbose();
		boolean enableTraces = options.isTracePrintingEnabled();
		String expression = options.getExpression();
		File modelFile = options.getModelFile(); // Check exists.

		Optional<File> optOutputFile = options.getOutputFile();
		Optional<File> optUppaalJarFile = options.getUppaalJar();

		OutputStream outStream;
		File outputFile = null;
		if (optOutputFile.isPresent()) {
			// TODO: file may be invalid.
			outputFile = optOutputFile.get();
			try
			{
				outStream = new FileOutputStream(outputFile);
			} catch (FileNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			// We will send results to std out; prevent outputting chatter.
			verbose = false;
			outStream = out;
		}

		Flag completionFlag = Flag.newInstance();
		PrintingErrorListener errorListener = new PrintingErrorListener(enableTraces, err,(errStatus) -> System.exit(errStatus.intValue()));
		PrintingProgressListener progressListener = new PrintingProgressListener(verbose ? out : null, completionFlag);

		FileInputStream sutModelStream;
		try {
			sutModelStream = new FileInputStream(modelFile);
		} catch (FileNotFoundException ex) {
			// FIXME.
			throw new RuntimeException(ex);
		}
		ByteArrayInputStream expressionStream = new ByteArrayInputStream(expression.getBytes());

		TdlInterpreter tdlInterpreter = TdlInterpreter
				.getInstance(errorListener, progressListener);

		tdlInterpreter.interpret(sutModelStream, expressionStream, outStream);

		if (completionFlag.isSet() && optUppaalJarFile.isPresent()) {
			if (outputFile != null) {
				// TODO: Try to run Uppaal jar with new file.
			}
		}

		System.exit(0);
	}

	public static void main(final String... args) {
		TdlCommandLineOptions options = new TdlCommandLineOptions();
		CmdLineParser argParser = new CmdLineParser(options);

		if (args.length == 0) {
			printHelp(argParser, out);
		} else {
			try {
				argParser.parseArgument(args);
				interpret(options);
			} catch (CmdLineException ex) {
				printUsageError(ex, argParser);
				System.exit(EReturnStatus.INVALID_ARGUMENTS.intValue());
			}
		}

		System.exit(EReturnStatus.SUCCESS.intValue());
	}
}
