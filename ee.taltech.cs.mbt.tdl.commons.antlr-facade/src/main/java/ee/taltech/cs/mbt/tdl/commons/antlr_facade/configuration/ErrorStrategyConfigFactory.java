package ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.base.ErrorStrategyConfig;

public class ErrorStrategyConfigFactory {
	public static ErrorStrategyConfig defaultConfig() {
		return failFastConfig();
	}

	public static ErrorStrategyConfig recoveryEnablerConfig() {
		ErrorStrategyConfig config = new ErrorStrategyConfig()
			.setRecoveryEnabled(true);
		config.getInlineErrorRecoveryConfig()
			.setEnabled(true)
			.setSingleTokenDeleteEnabled(true)
			.setSingleTokenInsertEnabled(true);
		return config;
	}

	public static ErrorStrategyConfig failFastConfig() {
		return new ErrorStrategyConfig()
			.setRecoveryEnabled(false);
	}
}
