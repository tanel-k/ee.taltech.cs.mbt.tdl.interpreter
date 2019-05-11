package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.STRegistry;

public class SExpressionGeneratorFactory {
	private static final String TEMPLATE_GROUP_PATH = "template-source/SExpressionLanguage.stg";

	private static final SExpressionGeneratorFactory INSTANCE = new SExpressionGeneratorFactory();
	private static final SExpressionGenerator EXPRESSION_GENERATOR;

	static {
		STRegistry stRegistry = STRegistry.fromGroupFilePath(TEMPLATE_GROUP_PATH);
		EXPRESSION_GENERATOR = new SExpressionGenerator(stRegistry);
	}

	public static SExpressionGeneratorFactory getInstance() {
		return INSTANCE;
	}

	public SExpressionGenerator getExpressionGenerator() {
		return EXPRESSION_GENERATOR;
	}

	private SExpressionGeneratorFactory() { }
}
