package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.STRegistry;

public class TdlGeneratorFactory {
	private static final String TEMPLATE_GROUP_PATH = "template-source/TdlExpressionLanguage.stg";

	private static final TdlExpressionGenerator EXPRESSION_GENERATOR;

	static {
		STRegistry stRegistry = STRegistry.fromGroupFilePath(TEMPLATE_GROUP_PATH);
		EXPRESSION_GENERATOR = new TdlExpressionGenerator(stRegistry);
	}

	private static final TdlGeneratorFactory INSTANCE = new TdlGeneratorFactory();

	public static TdlGeneratorFactory getInstance() {
		return INSTANCE;
	}

	private TdlGeneratorFactory() { }

	public TdlExpressionGenerator expressionGenerator() {
		return EXPRESSION_GENERATOR;
	}
}
