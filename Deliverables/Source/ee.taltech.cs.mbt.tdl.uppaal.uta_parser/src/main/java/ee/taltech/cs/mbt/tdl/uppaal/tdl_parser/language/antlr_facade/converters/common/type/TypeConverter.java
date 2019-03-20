package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr_facade.converters.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.TypeContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import org.antlr.v4.runtime.tree.ErrorNode;

public class TypeConverter extends UTALanguageBaseVisitor<Type<AbsTypeIdentifier>>
	implements IParseTreeConverter<Type<AbsTypeIdentifier>, TypeContext>
{
	@Override
	public Type<AbsTypeIdentifier> convert(TypeContext rootContext) throws ParseTreeStructureException {
		return rootContext.accept(this);
	}

	@Override
	public Type<AbsTypeIdentifier> visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Type subtree contains an error node (" + node.getText() + ")."
		);
	}

	@Override
	public Type<AbsTypeIdentifier> visitType(TypeContext ctx) {
		Type<AbsTypeIdentifier> type = new Type<>();
		type.setTypePrefix(new TypePrefixConverter().convert(ctx.typePrefix()));
		type.setTypeIdentifier(new TypeIdentifierConverter().convert(ctx.typeIdentifier()));
		return type;
	}
}
