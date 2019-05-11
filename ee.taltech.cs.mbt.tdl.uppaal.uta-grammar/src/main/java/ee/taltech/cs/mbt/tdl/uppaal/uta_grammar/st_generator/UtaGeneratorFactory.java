package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.STRegistry;

public class UtaGeneratorFactory {
	private static final String TEMPLATE_GROUP_PATH = "template-source/UtaLanguage.stg";

	private static final DeclarationGenerator DECLARATION_GENERATOR;
	private static final ExpressionGenerator EXPRESSION_GENERATOR;
	private static final SelectionGenerator SELECTION_GENERATOR;
	private static final SystemDefinitionGenerator SYSTEM_DEFINITION_GENERATOR;
	private static final ParameterGenerator PARAMETER_GENERATOR;
	private static final SynchronizationGenerator SYNCHRONIZATION_GENERATOR;

	static {
		STRegistry stRegistry = STRegistry.fromGroupFilePath(TEMPLATE_GROUP_PATH);

		DECLARATION_GENERATOR = new DeclarationGenerator(stRegistry);
		EXPRESSION_GENERATOR = new ExpressionGenerator(stRegistry);
		SELECTION_GENERATOR = new SelectionGenerator(stRegistry);
		SYSTEM_DEFINITION_GENERATOR = new SystemDefinitionGenerator(stRegistry);
		PARAMETER_GENERATOR = new ParameterGenerator(stRegistry);
		SYNCHRONIZATION_GENERATOR = new SynchronizationGenerator(stRegistry);
	}

	private static final UtaGeneratorFactory INSTANCE = new UtaGeneratorFactory();

	public static UtaGeneratorFactory getInstance() {
		return INSTANCE;
	}

	private UtaGeneratorFactory() { }

	public DeclarationGenerator declarationGenerator() {
		return DECLARATION_GENERATOR;
	}

	public ExpressionGenerator expressionGenerator() {
		return EXPRESSION_GENERATOR;
	}

	public SelectionGenerator selectionGenerator() {
		return SELECTION_GENERATOR;
	}

	public SystemDefinitionGenerator systemDefinitionGenerator() {
		return SYSTEM_DEFINITION_GENERATOR;
	}

	public ParameterGenerator parameterGenerator() {
		return PARAMETER_GENERATOR;
	}

	public SynchronizationGenerator synchronizationGenerator() {
		return SYNCHRONIZATION_GENERATOR;
	}
}
