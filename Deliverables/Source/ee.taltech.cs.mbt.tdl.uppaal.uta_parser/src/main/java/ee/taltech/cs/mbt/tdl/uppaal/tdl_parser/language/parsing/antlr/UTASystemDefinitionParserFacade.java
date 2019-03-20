package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.SystemDefinitionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaSystemDefinitionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;

public class UTASystemDefinitionParserFacade
	extends AbsUTAParserFacade<SystemDefinition, UtaSystemDefinitionContext, SystemDefinitionConverter>
{
	@Override
	protected UtaSystemDefinitionContext getRootContext(UTALanguageParser parser) {
		return parser.utaSystemDefinition();
	}

	@Override
	protected SystemDefinitionConverter getConverter() {
		return new SystemDefinitionConverter();
	}
}
