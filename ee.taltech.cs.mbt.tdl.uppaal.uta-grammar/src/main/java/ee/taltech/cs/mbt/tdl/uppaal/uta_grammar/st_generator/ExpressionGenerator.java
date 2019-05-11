package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;

import java.util.Optional;

public class ExpressionGenerator extends AbsSTGenerator<AbsExpression> {
	private static final String TEMPLATE_NAME = "expression";
	private static final String ITERABLE_TEMPLATE_NAME = "expressions";

	ExpressionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<AbsExpression> getContextExtractor() {
		return ExpressionCtxExtractor.getInstance();
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.of(ITERABLE_TEMPLATE_NAME);
	}
}
