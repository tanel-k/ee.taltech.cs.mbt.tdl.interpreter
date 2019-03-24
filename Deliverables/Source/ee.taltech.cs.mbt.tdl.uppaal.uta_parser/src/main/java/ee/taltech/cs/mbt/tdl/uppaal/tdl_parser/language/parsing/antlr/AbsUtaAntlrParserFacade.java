package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageLexer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class AbsUtaAntlrParserFacade<OutputType, RootContextType extends ParseTree>
	extends AbsAntlrParserFacade<OutputType, UtaLanguageParser, RootContextType>
{
	private RootContextType rootContext;

	@Override
	protected UtaLanguageParser getParserInstance(TokenStream tokenStream) {
		return new UtaLanguageParser(tokenStream);
	}

	@Override
	protected UtaLanguageLexer getLexerInstance(CharStream forInputStream) {
		return new UtaLanguageLexer(forInputStream);
	}
}
