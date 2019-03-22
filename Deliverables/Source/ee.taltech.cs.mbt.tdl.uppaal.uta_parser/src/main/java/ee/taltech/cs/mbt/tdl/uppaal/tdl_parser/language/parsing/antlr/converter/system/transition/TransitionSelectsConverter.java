package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SelectionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

import java.util.LinkedList;
import java.util.List;

public class TransitionSelectsConverter extends UTALanguageBaseVisitor<List<Selection>>
	implements IParseTreeConverter<List<Selection>, UtaTransitionSelectionSequenceContext> {
	@Override
	public List<Selection> convert(UtaTransitionSelectionSequenceContext rootContext) {
		List<Selection> selectionList = new LinkedList<>();
		for (SelectionContext selectionCtx : rootContext.selection()) {
			selectionList.add(new SelectionConverter().convert(selectionCtx));
		}
		return selectionList;
	}
}
