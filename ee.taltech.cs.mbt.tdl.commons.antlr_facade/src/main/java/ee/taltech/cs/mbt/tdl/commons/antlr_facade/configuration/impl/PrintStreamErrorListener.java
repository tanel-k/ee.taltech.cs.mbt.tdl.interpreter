package ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.impl;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorListener;

import java.io.PrintStream;

public class PrintStreamErrorListener extends ErrorListener {
	private PrintStream printStream;

	public PrintStreamErrorListener(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void registerSyntaxError(SyntaxError error) {
		this.printStream.println(error);
	}
}
