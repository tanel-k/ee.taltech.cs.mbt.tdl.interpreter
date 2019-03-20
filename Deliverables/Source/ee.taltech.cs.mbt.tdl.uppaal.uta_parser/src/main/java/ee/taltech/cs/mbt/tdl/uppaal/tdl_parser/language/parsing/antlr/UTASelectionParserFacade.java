package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition.TransitionSelectsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

import java.util.List;

public class UTASelectionParserFacade
	extends AbsUTAParserFacade<List<Selection<AbsTypeIdentifier>>, UtaTransitionSelectionSequenceContext, TransitionSelectsConverter>
{
	@Override
	protected UtaTransitionSelectionSequenceContext getRootContext(UTALanguageParser parser) {
		return parser.utaTransitionSelectionSequence();
	}

	@Override
	protected TransitionSelectsConverter getConverter() {
		return new TransitionSelectsConverter();
	}
}
