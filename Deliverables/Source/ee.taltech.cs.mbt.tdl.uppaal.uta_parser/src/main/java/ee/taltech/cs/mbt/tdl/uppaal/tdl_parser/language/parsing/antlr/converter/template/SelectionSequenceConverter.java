package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.template;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SelectionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

import java.util.LinkedList;
import java.util.List;

public class SelectionSequenceConverter extends UtaLanguageBaseVisitor<List<Selection>>
		implements IParseTreeConverter<List<Selection>, SelectionSequenceContext> {
	public static SelectionSequenceConverter getInstance() {
		return INSTANCE;
	}

	private static final SelectionSequenceConverter INSTANCE = new SelectionSequenceConverter();

	private SelectionSequenceConverter() { }

	@Override
	public List<Selection> convert(SelectionSequenceContext ctx) {
		List<Selection> selectionList = new LinkedList<>();
		for (SelectionContext selectionCtx : ctx.selection()) {
			selectionList.add(SelectionConverter.getInstance().convert(selectionCtx));
		}
		return selectionList;
	}
}
