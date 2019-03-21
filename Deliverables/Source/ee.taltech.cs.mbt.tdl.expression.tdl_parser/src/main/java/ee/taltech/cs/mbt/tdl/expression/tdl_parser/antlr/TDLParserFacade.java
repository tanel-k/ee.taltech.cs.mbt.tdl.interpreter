package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr;

import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TDLExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TDLExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TDLExpressionLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter.TDLParseTreeConverter;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import org.antlr.v4.runtime.*;

public class TDLParserFacade extends AbsAntlrParserFacade<
		ExpressionTree,
		TDLExpressionLanguageLexer,
		TDLExpressionLanguageParser,
		ExpressionContext,
		TDLParseTreeConverter
	> {
	@Override
	protected TDLExpressionLanguageParser getParserInstance(TokenStream tokenStream) {
		return new TDLExpressionLanguageParser(tokenStream);
	}

	@Override
	protected TDLExpressionLanguageLexer getLexerInstance(CharStream forInputStream) {
		return new TDLExpressionLanguageLexer(forInputStream);
	}

	@Override
	protected ExpressionContext getRootContext(TDLExpressionLanguageParser parser) {
		return parser.expression();
	}

	@Override
	protected TDLParseTreeConverter getConverter() {
		return new TDLParseTreeConverter();
	}

	public TDLParserFacade() {}
}