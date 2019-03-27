package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;

public class TypeConverter extends UtaLanguageBaseVisitor<Type<AbsTypeId>>
	implements IParseTreeConverter<Type<AbsTypeId>, TypeContext> {
	public static TypeConverter getInstance() {
		return INSTANCE;
	}

	private static final TypeConverter INSTANCE = new TypeConverter();

	private TypeConverter() { }

	@Override
	public Type<AbsTypeId> convert(TypeContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public Type<AbsTypeId> visitType(TypeContext ctx) {
		Type<AbsTypeId> type = new Type<>();
		type.setTypePrefix(TypePrefixConverter.getInstance().convert(ctx.typePrefix()));
		type.setTypeIdentifier(TypeIdentifierConverter.getInstance().convert(ctx.typeIdentifier()));
		return type;
	}
}
