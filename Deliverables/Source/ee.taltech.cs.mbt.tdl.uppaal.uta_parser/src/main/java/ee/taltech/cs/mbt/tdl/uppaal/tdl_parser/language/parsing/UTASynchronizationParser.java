package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UTASynchronizationParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.Synchronization;

public class UTASynchronizationParser extends AbsParser<UTASynchronizationParserFacade, Synchronization> {
	@Override
	protected UTASynchronizationParserFacade constructFacade() {
		return new UTASynchronizationParserFacade();
	}
}
