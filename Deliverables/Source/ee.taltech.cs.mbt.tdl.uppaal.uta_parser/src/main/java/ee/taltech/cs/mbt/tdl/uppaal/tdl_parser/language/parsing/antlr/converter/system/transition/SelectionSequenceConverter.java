package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SelectionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.UtaTransitionSelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.template.Selection;

import java.util.LinkedList;
import java.util.List;

public class SelectionSequenceConverter extends UtaLanguageBaseVisitor<List<Selection>>
	implements IParseTreeConverter<List<Selection>, UtaTransitionSelectionSequenceContext>
{
	public static SelectionSequenceConverter getInstance() {
		return INSTANCE;
	}

	private static final SelectionSequenceConverter INSTANCE = new SelectionSequenceConverter();

	private SelectionSequenceConverter() { }

	@Override
	public List<Selection> convert(UtaTransitionSelectionSequenceContext rootContext) {
		List<Selection> selectionList = new LinkedList<>();
		for (SelectionContext selectionCtx : rootContext.selection()) {
			selectionList.add(SelectionConverter.getInstance().convert(selectionCtx));
		}
		return selectionList;
	}
}
