package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SelectionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

public class SelectionConverter extends UtaLanguageBaseVisitor<Selection<AbsTypeId>>
	implements IParseTreeConverter<Selection<AbsTypeId>, SelectionContext>
{
	public static SelectionConverter getInstance() {
		return INSTANCE;
	}

	private static final SelectionConverter INSTANCE = new SelectionConverter();

	private SelectionConverter() { }

	@Override
	public Selection<AbsTypeId> convert(SelectionContext rootContext) {
		Selection<AbsTypeId> selection = new Selection<>();
		Type<AbsTypeId> sourceType = TypeConverter.getInstance().convert(rootContext.type());
		Identifier targetIdentifier = new Identifier();
		targetIdentifier.setName(rootContext.IDENTIFIER_NAME().getText());
		selection.setSelectType(sourceType);
		selection.setVariable(targetIdentifier);
		return selection;
	}
}
