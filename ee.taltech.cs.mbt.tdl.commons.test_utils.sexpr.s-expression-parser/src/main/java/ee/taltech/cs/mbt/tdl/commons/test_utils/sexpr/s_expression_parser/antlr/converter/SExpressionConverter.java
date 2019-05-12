package ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SExprContext;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.SExpression;

public class SExpressionConverter implements IParseTreeConverter<SExpression, SExprContext> {
	private static final SExpressionConverter INSTANCE = new SExpressionConverter();

	public static SExpressionConverter getInstance() {
		return INSTANCE;
	}

	private SExpressionConverter() { }

	@Override
	public SExpression convert(SExprContext ctx) {
		return new SExpression().setRoot(
				SequenceConverter.getInstance().convert(ctx.sequence())
		);
	}
}
