package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.STRegistry;

public class SExpressionGeneratorFactory {
	private static final String TEMPLATE_GROUP_PATH = "template-source/SExpressionLanguage.stg";

	private static final STRegistry ST_REGISTRY;
	private static final SExpressionGeneratorFactory INSTANCE = new SExpressionGeneratorFactory();
	private static final SExpressionGenerator EXPRESSION_GENERATOR;

	static {
		ST_REGISTRY = STRegistry.fromGroupFilePath(TEMPLATE_GROUP_PATH);
		EXPRESSION_GENERATOR = new SExpressionGenerator(ST_REGISTRY);
	}

	public static SExpressionGeneratorFactory getInstance() {
		return INSTANCE;
	}

	public SExpressionGenerator getPrettyPrintingExpressionGenerator() {
		return new SExpressionGenerator(true, ST_REGISTRY);
	}

	public SExpressionGenerator getExpressionGenerator() {
		return EXPRESSION_GENERATOR;
	}

	private SExpressionGeneratorFactory() { }
}
