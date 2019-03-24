package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

public class TypeConverter extends UtaLanguageBaseVisitor<Type<AbsTypeIdentifier>>
	implements IParseTreeConverter<Type<AbsTypeIdentifier>, TypeContext> {
	public static TypeConverter getInstance() {
		return INSTANCE;
	}

	private static final TypeConverter INSTANCE = new TypeConverter();

	private TypeConverter() { }

	@Override
	public Type<AbsTypeIdentifier> convert(TypeContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public Type<AbsTypeIdentifier> visitType(TypeContext ctx) {
		Type<AbsTypeIdentifier> type = new Type<>();
		type.setTypePrefix(TypePrefixConverter.getInstance().convert(ctx.typePrefix()));
		type.setTypeIdentifier(TypeIdentifierConverter.getInstance().convert(ctx.typeIdentifier()));
		return type;
	}
}
