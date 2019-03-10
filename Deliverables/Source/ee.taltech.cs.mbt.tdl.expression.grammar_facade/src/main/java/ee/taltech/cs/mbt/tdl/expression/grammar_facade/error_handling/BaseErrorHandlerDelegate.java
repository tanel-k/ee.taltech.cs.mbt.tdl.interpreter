package ee.taltech.cs.mbt.tdl.expression.grammar_facade.error_handling;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

public class BaseErrorHandlerDelegate {
	protected static class DelegatingANTLRErrorListener implements ANTLRErrorListener {
		private BaseErrorHandlerDelegate delegate = null;

		DelegatingANTLRErrorListener(BaseErrorHandlerDelegate delegate) {
			this.delegate = delegate;
		}

		@Override
		public void syntaxError(
			Recognizer<?, ?> recognizer,
			Object offendingSymbol,
			int line,
			int charPositionInLine,
			String msg,
			RecognitionException e) {

		}

		@Override
		public void reportAmbiguity(
			Parser recognizer,
			DFA dfa,
			int startIndex,
			int stopIndex,
			boolean exact,
			BitSet ambigAlts,
			ATNConfigSet configs
		) {

		}

		@Override
		public void reportAttemptingFullContext(
			Parser recognizer,
			DFA dfa,
			int startIndex,
			int stopIndex,
			BitSet conflictingAlts,
			ATNConfigSet configs
		) {

		}

		@Override
		public void reportContextSensitivity(
			Parser recognizer,
			DFA dfa,
			int startIndex,
			int stopIndex,
			int prediction,
			ATNConfigSet configs) {

		}
	}

	protected ANTLRErrorListener toDelegatedListener() {
		return new DelegatingANTLRErrorListener(this);
	}

	BaseErrorHandlerDelegate() { }
}
