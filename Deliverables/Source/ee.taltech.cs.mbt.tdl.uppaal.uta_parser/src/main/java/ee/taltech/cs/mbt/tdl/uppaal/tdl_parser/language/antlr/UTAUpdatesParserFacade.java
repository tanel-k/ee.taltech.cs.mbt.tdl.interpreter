package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.system.transition.TransitionUpdatesConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionUpdateListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.List;

public class UTAUpdatesParserFacade
	extends AbsUTAParserFacade<List<AbsExpression>, UtaTransitionUpdateListContext, TransitionUpdatesConverter>
{
	@Override
	protected UtaTransitionUpdateListContext getRootContext(UTALanguageParser parser) {
		return parser.utaTransitionUpdateList();
	}

	@Override
	protected TransitionUpdatesConverter getConverter() {
		return new TransitionUpdatesConverter();
	}
}
