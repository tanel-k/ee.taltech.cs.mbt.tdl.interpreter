package ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_parser.antlr;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SExprContext;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_parser.antlr.converter.SExpressionConverter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;

public class SExpressionParserFacade extends AbsAntlrParserFacade<SExpression, SExpressionLanguageParser, SExpressionLanguageLexer, SExprContext> {
	@Override
	protected SExpressionLanguageParser getParserInstance(TokenStream tokenStream) {
		return new SExpressionLanguageParser(tokenStream);
	}

	@Override
	protected SExpressionLanguageLexer getLexerInstance(CharStream forInputStream) {
		return new SExpressionLanguageLexer(forInputStream);
	}

	@Override
	protected SExprContext getRootContext(SExpressionLanguageParser parser) {
		return parser.sExpr();
	}

	@Override
	protected IParseTreeConverter<SExpression, SExprContext> getConverter() {
		return SExpressionConverter.getInstance();
	}
}
