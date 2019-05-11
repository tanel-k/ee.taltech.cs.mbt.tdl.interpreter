package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.st_generator.extractors.SExpressionContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_model.SExpression;

import java.util.Optional;

public class SExpressionGenerator extends AbsSTGenerator<SExpression> {
	protected SExpressionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected String getTemplateName() {
		return "sExpr";
	}

	@Override
	protected IContextExtractor<SExpression> getContextExtractor() {
		return SExpressionContextExtractor.getInstance();
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.empty();
	}
}
