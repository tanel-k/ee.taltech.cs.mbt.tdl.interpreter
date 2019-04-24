package ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.bridge;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorStrategyConfig;
import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorStrategyConfig.RecognitionExceptionWrapper;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.IntervalSet;

public class ConfigurableAntlrErrorStrategy extends DefaultErrorStrategy {
	private ErrorStrategyConfig strategyConfig;

	private String getFailedPredicateMessage(Parser recognizer, FailedPredicateException ex) {
		String ruleName = recognizer.getRuleNames()[
				recognizer.getRuleContext().getRuleIndex()
				];
		return strategyConfig.getFailedPredicateMessage(ruleName, ex);
	}

	private String getMismatchMessage(Parser recognizer, InputMismatchException ex) {
		return strategyConfig.getMismatchMessage(
				getTokenErrorDisplay(ex.getOffendingToken()),
				ex.getExpectedTokens().toString(recognizer.getVocabulary())
		);
	}

	private String getMissingTokenMessage(Parser recognizer, Token currentToken) {
		IntervalSet expecting = getExpectedTokens(recognizer);
		return strategyConfig.getMissingTokenMessage(
				expecting.toString(recognizer.getVocabulary()),
				getTokenErrorDisplay(currentToken)
		);
	}

	private String getNoViableAltMessage(Parser recognizer, NoViableAltException ex) {
		TokenStream tokens = recognizer.getInputStream();
		String input;
		if (tokens != null) {
			if (Token.EOF == ex.getStartToken().getType()) {
				input = "<EOF>";
			} else {
				input = tokens.getText(ex.getStartToken(), ex.getOffendingToken());
			}
		} else {
			input = "<unknown input>";
		}
		return strategyConfig.getNoViableAltMessage(escapeWSAndQuote(input));
	}

	private String getExtraneousTokenMessage(Parser recognizer, Token currentToken) {
		String tokenName = getTokenErrorDisplay(currentToken);
		IntervalSet expecting = getExpectedTokens(recognizer);
		return strategyConfig.getExtraneousTokenMessage(tokenName, expecting.toString(recognizer.getVocabulary()));
	}

	private RecognitionExceptionWrapper wrapRecognitionException(Parser recognizer, RecognitionException ex) {
		if (ex instanceof NoViableAltException) {
			return new RecognitionExceptionWrapper(getNoViableAltMessage(recognizer, (NoViableAltException) ex), ex);
		} else if (ex instanceof InputMismatchException) {
			return new RecognitionExceptionWrapper(getMismatchMessage(recognizer, (InputMismatchException) ex), ex);
		} else if (ex instanceof FailedPredicateException) {
			return new RecognitionExceptionWrapper(getFailedPredicateMessage(recognizer, (FailedPredicateException) ex), ex);
		} else {
			return new RecognitionExceptionWrapper(
				"Recognition failed at token " + getTokenErrorDisplay(ex.getOffendingToken()) + ": " + ex.getMessage(), ex
			);
		}
	}

	@Override
	protected void reportFailedPredicate(Parser recognizer, FailedPredicateException ex) {
		recognizer.notifyErrorListeners(ex.getOffendingToken(), getFailedPredicateMessage(recognizer, ex), ex);
	}

	@Override
	protected void reportInputMismatch(Parser recognizer, InputMismatchException ex) {
		recognizer.notifyErrorListeners(ex.getOffendingToken(), getMismatchMessage(recognizer, ex), ex);
	}

	@Override
	protected void reportMissingToken(Parser recognizer) {
		if (inErrorRecoveryMode(recognizer)) {
			return;
		}
		beginErrorCondition(recognizer);
		Token currentToken = recognizer.getCurrentToken();
		recognizer.notifyErrorListeners(currentToken, getMissingTokenMessage(recognizer, currentToken), null);
	}

	@Override
	protected void reportNoViableAlternative(Parser recognizer, NoViableAltException ex) {
		recognizer.notifyErrorListeners(ex.getOffendingToken(), getNoViableAltMessage(recognizer, ex), ex);
	}

	@Override
	protected void reportUnwantedToken(Parser recognizer) {
		if (inErrorRecoveryMode(recognizer)) {
			return;
		}

		beginErrorCondition(recognizer);

		Token currentToken = recognizer.getCurrentToken();
		recognizer.notifyErrorListeners(currentToken, getExtraneousTokenMessage(recognizer, currentToken), null);
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

	public ConfigurableAntlrErrorStrategy(ErrorStrategyConfig strategyConfig) {
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
		if (!strategyConfig.isRecoveryEnabled()) {
			reportError(recognizer, ex); // Will not be reported otherwise.
			throw wrapRecognitionException(recognizer, ex);
		}

		super.recover(recognizer, ex);
	}

	@Override
	public Token recoverInline(Parser recognizer) throws RecognitionException {
		if (!strategyConfig.getInlineErrorRecoveryConfig().isEnabled()) {
			InputMismatchException ex = new InputMismatchException(recognizer);
			reportError(recognizer, ex); // Will not be reported otherwise.
			throw wrapRecognitionException(recognizer, new InputMismatchException(recognizer));
		}

		return super.recoverInline(recognizer);
	}

	@Override
	public void sync(Parser recognizer) throws RecognitionException {
		if (!strategyConfig.isRecoveryEnabled())
			return;

		super.sync(recognizer);
	}
}
