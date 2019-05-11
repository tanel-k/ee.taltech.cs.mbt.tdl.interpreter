package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_parser.antlr;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.SexprContext;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_parser.antlr.converter.SExpressionConverter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;

public class SExpressionParserFacade extends AbsAntlrParserFacade<SExpression, SExpressionLanguageParser, SExpressionLanguageLexer, SexprContext> {
	@Override
	protected SExpressionLanguageParser getParserInstance(TokenStream tokenStream) {
		return new SExpressionLanguageParser(tokenStream);
	}

	@Override
	protected SExpressionLanguageLexer getLexerInstance(CharStream forInputStream) {
		return new SExpressionLanguageLexer(forInputStream);
	}

	@Override
	protected SexprContext getRootContext(SExpressionLanguageParser parser) {
		return parser.sexpr();
	}

	@Override
	protected IParseTreeConverter<SExpression, SexprContext> getConverter() {
		return SExpressionConverter.getInstance();
	}
}
