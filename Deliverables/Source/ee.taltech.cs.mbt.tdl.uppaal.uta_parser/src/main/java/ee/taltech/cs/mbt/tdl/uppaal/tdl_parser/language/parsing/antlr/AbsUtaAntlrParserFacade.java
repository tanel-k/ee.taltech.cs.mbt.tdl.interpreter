package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageLexer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class AbsUtaAntlrParserFacade<OutputType, RootContextType extends ParseTree>
	extends AbsAntlrParserFacade<OutputType, UTALanguageLexer, UTALanguageParser, RootContextType>
{
	private RootContextType rootContext;

	@Override
	protected UTALanguageParser getParserInstance(TokenStream tokenStream) {
		return new UTALanguageParser(tokenStream);
	}

	@Override
	protected UTALanguageLexer getLexerInstance(CharStream forInputStream) {
		return new UTALanguageLexer(forInputStream);
	}
}
