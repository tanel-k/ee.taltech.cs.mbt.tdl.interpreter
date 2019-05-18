package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator.extractors.SExpressionContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;

import java.util.Optional;

public class SExpressionGenerator extends AbsSTGenerator<SExpression> {
	protected boolean prettyPrintMode = false;

	@Override
	protected void prepareContext(ContextBuilder ctx) {
		ctx.put("prettyPrint", prettyPrintMode);
	}

	protected SExpressionGenerator(boolean prettyPrintMode, STRegistry stRegistry) {
		super(stRegistry);
		this.prettyPrintMode = prettyPrintMode;
	}

	protected SExpressionGenerator(STRegistry stRegistry) {
		this(false, stRegistry);
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
