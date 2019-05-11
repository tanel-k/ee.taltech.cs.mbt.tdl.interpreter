package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SexprContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.SExpression;

public class SExpressionConverter implements IParseTreeConverter<SExpression, SexprContext> {
	private static final SExpressionConverter INSTANCE = new SExpressionConverter();

	public static SExpressionConverter getInstance() {
		return INSTANCE;
	}

	private SExpressionConverter() { }

	@Override
	public SExpression convert(SexprContext ctx) {
		return new SExpression().setRoot(
				SequenceConverter.getInstance().convert(ctx.sequence())
		);
	}
}
