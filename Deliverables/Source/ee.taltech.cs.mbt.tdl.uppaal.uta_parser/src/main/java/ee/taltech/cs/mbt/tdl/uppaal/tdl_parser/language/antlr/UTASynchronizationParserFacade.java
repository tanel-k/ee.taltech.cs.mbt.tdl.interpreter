package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.system.transition.SynchronizationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSynchronizationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.Synchronization;

public class UTASynchronizationParserFacade
	extends AbsUTAParserFacade<Synchronization, UtaTransitionSynchronizationContext, SynchronizationConverter>
{
	@Override
	protected UtaTransitionSynchronizationContext getRootContext(UTALanguageParser parser) {
		return parser.utaTransitionSynchronization();
	}

	@Override
	protected SynchronizationConverter getConverter() {
		return new SynchronizationConverter();
	}
}
