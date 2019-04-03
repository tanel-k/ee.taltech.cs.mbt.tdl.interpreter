package ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageLexer;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser;
import ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser.TdlExpressionLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.converter.TdlParseTreeConverter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;

public class TdlParserFacade extends AbsAntlrParserFacade<ExpressionTree, TdlExpressionLanguageParser, ExpressionContext> {
	@Override
	protected TdlExpressionLanguageParser getParserInstance(TokenStream tokenStream) {
		return new TdlExpressionLanguageParser(tokenStream);
	}

	@Override
	protected TdlExpressionLanguageLexer getLexerInstance(CharStream forInputStream) {
		return new TdlExpressionLanguageLexer(forInputStream);
	}

	@Override
	protected ExpressionContext getRootContext(TdlExpressionLanguageParser parser) {
		return parser.expression();
	}

	@Override
	protected TdlParseTreeConverter getConverter() {
		return new TdlParseTreeConverter();
	}

	public TdlParserFacade() {}
}
