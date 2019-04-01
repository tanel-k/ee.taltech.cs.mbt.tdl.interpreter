package ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.base;

import org.antlr.v4.runtime.RecognitionException;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorStrategyConfig {
	public static class RecognitionExceptionWrapper extends RuntimeException {
		public RecognitionExceptionWrapper(String msg, RecognitionException cause) {
			super(msg, cause);
		}

		@Override
		public String toString() {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			pw.println("Recognition failure: " + getMessage() + ".");
			if (getCause() != null)
				getCause().printStackTrace(pw);
			pw.println();

			return sw.toString();
		}
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

	private boolean recoveryEnabled = true;

	private InlineErrorRecoveryConfig inlineErrorRecoveryConfig  = new InlineErrorRecoveryConfig(this)
			.setEnabled(true)
			.setSingleTokenDeleteEnabled(true)
			.setSingleTokenInsertEnabled(true);

	public boolean isRecoveryEnabled() {
		return recoveryEnabled;
	}

	public InlineErrorRecoveryConfig getInlineErrorRecoveryConfig() {
		return inlineErrorRecoveryConfig;
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
