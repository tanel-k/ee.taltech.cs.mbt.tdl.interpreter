package ee.taltech.cs.mbt.tdl.expression.tdl_grammar_facade.facade_impl.configuration;

public class ErrorStrategyConfig {
	public static class InvalidExpressionException extends RuntimeException {
		public InvalidExpressionException() { super(); }
		public InvalidExpressionException(Throwable t) { super(t); }
		public InvalidExpressionException(String msg, Throwable t) { super(msg, t); }
		public InvalidExpressionException(String msg) { super(msg); }
	}

	public static class InlineErrorRecoveryConfig {
		private ErrorStrategyConfig parentConfig;
		private boolean enabled = true;
		private boolean singleTokenInsertEnabled = true;
		private boolean singleTokenDeleteEnabled = true;

		private InlineErrorRecoveryConfig(ErrorStrategyConfig parentConfig) {
			this.parentConfig = parentConfig;
		}

		public boolean isEnabled() {
			return parentConfig.isRecoveryEnabled() && enabled;
		}

		public InlineErrorRecoveryConfig setEnabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public boolean isSingleTokenDeleteEnabled() {
			return singleTokenDeleteEnabled;
		}

		public InlineErrorRecoveryConfig setSingleTokenDeleteEnabled(boolean singleTokenDeleteEnabled) {
			this.singleTokenDeleteEnabled = singleTokenDeleteEnabled;
			return this;
		}

		public boolean isSingleTokenInsertEnabled() {
			return singleTokenInsertEnabled;
		}

		public InlineErrorRecoveryConfig setSingleTokenInsertEnabled(boolean singleTokenInsertEnabled) {
			this.singleTokenInsertEnabled = singleTokenInsertEnabled;
			return this;
		}
	}

	private InlineErrorRecoveryConfig inlineErrorRecoveryConfig;

	public InlineErrorRecoveryConfig getInlineErrorRecoveryConfig() {
		return inlineErrorRecoveryConfig;
	}

	public ErrorStrategyConfig() {
		this.inlineErrorRecoveryConfig = new InlineErrorRecoveryConfig(this)
			.setEnabled(true)
			.setSingleTokenDeleteEnabled(true)
			.setSingleTokenInsertEnabled(true);
	}

	private boolean recoveryEnabled = true;

	public boolean isRecoveryEnabled() {
		return recoveryEnabled;
	}

	public String getNoViableAltMessage(String input) {
		return "No viable alternative at " + input;
	}

	public String getFailedPredicateMessage(String ruleName, Exception ex) {
		return "Rule " + ruleName + " threw exception: " + ex.getMessage();
	}

	public String getMismatchMessage(String actualInput, String expectedInput) {
		return "Input mismatch, received " + actualInput + ", expected " + expectedInput;
	}

	public String getMissingTokenMessage(String expectedToken, String location) {
		return "Missing " + expectedToken + " at " + location;
	}

	public String getExtraneousTokenMessage(String actualInput, String expectedInput) {
		return "Extraneous input " + actualInput + ", expecting " + expectedInput;
	}

	public ErrorStrategyConfig setRecoveryEnabled(boolean recoveryEnabled) {
		this.recoveryEnabled = recoveryEnabled;
		return this;
	}
}
