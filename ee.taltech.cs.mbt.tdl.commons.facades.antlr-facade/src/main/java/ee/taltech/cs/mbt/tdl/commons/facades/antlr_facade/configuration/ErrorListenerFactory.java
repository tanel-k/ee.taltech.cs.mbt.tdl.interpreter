package ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.base.ErrorListener;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.base.ErrorListener.SyntaxError;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.impl.CollectingErrorListener;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.impl.NoOpErrorListener;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.configuration.impl.PrintStreamErrorListener;

import java.io.PrintStream;
import java.util.Collection;

public class ErrorListenerFactory {
	public static ErrorListener defaultListener() {
		return silentListener();
	}

	public static NoOpErrorListener silentListener() {
		return new NoOpErrorListener();
	}

	public static PrintStreamErrorListener consoleListener() {
		return printStreamListener(System.err);
	}

	public static PrintStreamErrorListener printStreamListener(PrintStream stream) {
		return new PrintStreamErrorListener(stream);
	}

	public static CollectingErrorListener collectingListener(Collection<SyntaxError> errorCollection) {
		return new CollectingErrorListener(errorCollection);
	}
}
