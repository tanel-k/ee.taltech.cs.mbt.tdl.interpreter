package ee.taltech.cs.mbt.tdl.expression.grammar_facade.facade_impl;

import ee.taltech.cs.mbt.tdl.expression.grammar_facade.facade_impl.configuration.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.expression.grammar_facade.facade_impl.configuration.ErrorStrategyConfig.InvalidExpressionException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;

class ConfigurableErrorStrategy extends DefaultErrorStrategy {
	private ErrorStrategyConfig strategyConfig;

	@Override
	protected void reportFailedPredicate(Parser recognizer, FailedPredicateException ex) {
		String ruleName = recognizer.getRuleNames()[
				recognizer.getRuleContext().getRuleIndex()
				];
		String msg = strategyConfig.getFailedPredicateMessage(ruleName, ex);
		recognizer.notifyErrorListeners(ex.getOffendingToken(), msg, ex);
	}

	@Override
	protected void reportInputMismatch(Parser recognizer, InputMismatchException ex) {
		String msg = strategyConfig.getMismatchMessage(
				getTokenErrorDisplay(ex.getOffendingToken()),
				ex.getExpectedTokens().toString(recognizer.getVocabulary())
		);
		recognizer.notifyErrorListeners(ex.getOffendingToken(), msg, ex);
	}

	@Override
	protected void reportMissingToken(Parser recognizer) {
		if (inErrorRecoveryMode(recognizer)) {
			return;
		}
		beginErrorCondition(recognizer);

		Token t = recognizer.getCurrentToken();
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = strategyConfig.getMissingTokenMessage(
				expecting.toString(recognizer.getVocabulary()),
				getTokenErrorDisplay(t)
		);
		recognizer.notifyErrorListeners(t, msg, null);
	}

	@Override
	protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
		TokenStream tokens = recognizer.getInputStream();
		String input;
		if (tokens != null) {
			if (Token.EOF == e.getStartToken().getType()) {
				input = "<EOF>";
			} else {
				input = tokens.getText(e.getStartToken(), e.getOffendingToken());
			}
		} else {
			input = "<unknown input>";
		}
		String msg = strategyConfig.getNoViableAltMessage(escapeWSAndQuote(input));
		recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
	}

	@Override
	protected void reportUnwantedToken(Parser recognizer) {
		if (inErrorRecoveryMode(recognizer)) {
			return;
		}
		beginErrorCondition(recognizer);

		Token t = recognizer.getCurrentToken();
		String tokenName = getTokenErrorDisplay(t);
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = strategyConfig.getExtraneousTokenMessage(tokenName, expecting.toString(recognizer.getVocabulary()));
		recognizer.notifyErrorListeners(t, msg, null);
	}

	@Override
	protected boolean singleTokenInsertion(Parser recognizer) {
		return strategyConfig.getInlineErrorRecoveryConfig().isSingleTokenInsertEnabled()
				&& super.singleTokenInsertion(recognizer);
	}

	@Override
	protected Token singleTokenDeletion(Parser recognizer) {
		if (!strategyConfig.getInlineErrorRecoveryConfig().isSingleTokenDeleteEnabled())
			return null;
		return super.singleTokenDeletion(recognizer);
	}

	ConfigurableErrorStrategy(ErrorStrategyConfig strategyConfig) {
		this.strategyConfig = strategyConfig;
	}

	public ErrorStrategyConfig getStrategyConfig() {
		return strategyConfig;
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e) {
		if (inErrorRecoveryMode(recognizer)) {
			return;
		}

		beginErrorCondition(recognizer);

		if (e instanceof NoViableAltException) {
			reportNoViableAlternative(recognizer, (NoViableAltException) e);
		} else if (e instanceof InputMismatchException) {
			reportInputMismatch(recognizer, (InputMismatchException) e);
		} else if (e instanceof FailedPredicateException) {
			reportFailedPredicate(recognizer, (FailedPredicateException) e);
		} else {
			recognizer.notifyErrorListeners(e.getOffendingToken(), e.getMessage(), e);
		}
	}

	@Override
	public void recover(Parser recognizer, RecognitionException ex) {
		if (!strategyConfig.isRecoveryEnabled())
			throw new InvalidExpressionException(ex);
		super.recover(recognizer, ex);
	}

	@Override
	public void sync(Parser recognizer) throws RecognitionException {
		if (!strategyConfig.isRecoveryEnabled())
			return;
		super.sync(recognizer);
	}

	@Override
	public Token recoverInline(Parser recognizer) throws RecognitionException {
		if (!strategyConfig.getInlineErrorRecoveryConfig().isEnabled())
			throw new InvalidExpressionException(new InputMismatchException(recognizer));
		return super.recoverInline(recognizer);
	}
}
