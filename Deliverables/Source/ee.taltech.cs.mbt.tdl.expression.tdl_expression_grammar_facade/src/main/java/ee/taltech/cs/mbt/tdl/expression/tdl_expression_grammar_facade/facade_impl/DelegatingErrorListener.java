package ee.taltech.cs.mbt.tdl.expression.tdl_expression_grammar_facade.facade_impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_expression_grammar_facade.facade_impl.configuration.ErrorListener;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_grammar_facade.facade_impl.configuration.ErrorListener.SyntaxError;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

class DelegatingErrorListener extends org.antlr.v4.runtime.BaseErrorListener implements IDelegator<ErrorListener> {
	private ErrorListener listenerDelegate = null;

	DelegatingErrorListener(ErrorListener listenerDelegate) {
		this.listenerDelegate = listenerDelegate;
	}

	@Override
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
