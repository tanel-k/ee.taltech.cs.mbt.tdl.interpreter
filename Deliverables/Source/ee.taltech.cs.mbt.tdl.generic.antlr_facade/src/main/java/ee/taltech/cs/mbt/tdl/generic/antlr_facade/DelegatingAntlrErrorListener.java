package ee.taltech.cs.mbt.tdl.generic.antlr_facade;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorListener;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorListener.SyntaxError;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

class DelegatingAntlrErrorListener extends org.antlr.v4.runtime.BaseErrorListener {
	private ErrorListener listenerDelegate = null;

	DelegatingAntlrErrorListener(ErrorListener listenerDelegate) {
		this.listenerDelegate = listenerDelegate;
	}

	public ErrorListener getDelegate() {
		return listenerDelegate;
	}

	@Override
	public void syntaxError(
			Recognizer<?, ?> recognizer,
			Object offendingSymbol,
			int line,
			int charPositionInLine,
			String msg,
			RecognitionException e
	) {
		SyntaxError syntaxError = new ErrorListener.SyntaxError()
				.setOffendingSymbol(offendingSymbol)
				.setLine(line)
				.setCharPositionInLine(charPositionInLine)
				.setMessage(msg)
				.setException(e);
		listenerDelegate.registerSyntaxError(syntaxError);
	}
}
