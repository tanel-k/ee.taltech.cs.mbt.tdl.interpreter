package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_parser;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_parser.antlr.SExpressionParserFacade;

public class SExpressionParser extends AbsAntlrParser<SExpression> {
	private static final SExpressionParser INSTANCE = new SExpressionParser();

	public static SExpressionParser getInstance() {
		return INSTANCE;
	}

	private SExpressionParser() { }

	@Override
	public AbsAntlrParserFacade<SExpression, ?, ?, ?> getFacade() {
		return new SExpressionParserFacade();
	}
}
