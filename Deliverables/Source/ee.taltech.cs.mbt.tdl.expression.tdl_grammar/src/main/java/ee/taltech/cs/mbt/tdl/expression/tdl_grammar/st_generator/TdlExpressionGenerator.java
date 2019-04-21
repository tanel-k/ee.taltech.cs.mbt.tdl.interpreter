package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator.extractors.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

import java.util.Optional;

public class TdlExpressionGenerator extends AbsSTGenerator<TdlExpression> {
	private static final String TEMPLATE_NAME = "expression";

	protected TdlExpressionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<TdlExpression> getContextExtractor() {
		return ExpressionCtxExtractor.getInstance();
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.empty();
	}
}
