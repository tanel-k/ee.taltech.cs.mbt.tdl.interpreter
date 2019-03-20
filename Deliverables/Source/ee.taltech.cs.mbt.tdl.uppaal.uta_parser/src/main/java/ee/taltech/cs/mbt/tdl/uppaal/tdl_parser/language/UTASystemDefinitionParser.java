package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.UTASystemDefinitionParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;

public class UTASystemDefinitionParser extends AbsParser<UTASystemDefinitionParserFacade, SystemDefinition> {
	@Override
	protected UTASystemDefinitionParserFacade constructFacade() {
		return new UTASystemDefinitionParserFacade();
	}
}
