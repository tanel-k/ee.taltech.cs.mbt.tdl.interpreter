package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SelectionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.transition.SelectionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

import java.util.LinkedList;
import java.util.List;

public class TransitionSelectsConverter extends UTALanguageBaseVisitor<List<Selection<AbsTypeIdentifier>>>
	implements IParseTreeConverter<List<Selection<AbsTypeIdentifier>>, UtaTransitionSelectionSequenceContext> {
	@Override
	public List<Selection<AbsTypeIdentifier>> convert(
		UtaTransitionSelectionSequenceContext rootContext) throws ParseTreeStructureException
	{
		List<Selection<AbsTypeIdentifier>> selectionList = new LinkedList<>();
		for (SelectionContext selectionCtx : rootContext.selection()) {
			selectionList.add(new SelectionConverter().convert(selectionCtx));
		}
		return selectionList;
	}
}
