package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr_facade.converters.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.SelectionContext;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr_facade.converters.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

public class SelectionConverter extends UTALanguageBaseVisitor<Selection<AbsTypeIdentifier>>
	implements IParseTreeConverter<Selection<AbsTypeIdentifier>, SelectionContext>
{
	@Override
	public Selection<AbsTypeIdentifier> convert(SelectionContext rootContext) throws ParseTreeStructureException {
		Selection<AbsTypeIdentifier> selection = new Selection<>();
		Type<AbsTypeIdentifier> sourceType = new TypeConverter().convert(rootContext.type());
		IdentifierName targetIdentifier = new IdentifierName();
		targetIdentifier.setName(rootContext.IDENTIFIER_NAME().getText());
		selection.setSelectionSourceType(sourceType);
		selection.setVariable(targetIdentifier);
		return selection;
	}
}
