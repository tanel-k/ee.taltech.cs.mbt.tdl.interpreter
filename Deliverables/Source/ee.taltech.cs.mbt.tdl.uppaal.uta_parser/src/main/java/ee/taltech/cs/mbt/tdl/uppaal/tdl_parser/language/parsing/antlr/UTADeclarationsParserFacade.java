package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.declaration.DeclarationsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaDeclarationsContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;

import java.util.List;

public class UTADeclarationsParserFacade
	extends AbsUTAParserFacade<List<AbsDeclarationStatement>, UtaDeclarationsContext, DeclarationsConverter>
{
	@Override
	protected UtaDeclarationsContext getRootContext(UTALanguageParser parser) {
		return parser.utaDeclarations();
	}

	@Override
	protected DeclarationsConverter getConverter() {
		return new DeclarationsConverter();
	}
}
