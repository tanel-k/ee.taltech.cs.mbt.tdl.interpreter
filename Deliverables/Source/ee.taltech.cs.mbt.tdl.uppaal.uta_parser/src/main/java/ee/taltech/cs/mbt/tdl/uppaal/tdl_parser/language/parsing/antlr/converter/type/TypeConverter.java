package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;

public class TypeConverter extends UtaLanguageBaseVisitor<Type>
		implements IParseTreeConverter<Type, TypeContext> {
	public static TypeConverter getInstance() {
		return INSTANCE;
	}

	private static final TypeConverter INSTANCE = new TypeConverter();

	private TypeConverter() { }

	@Override
	public Type convert(TypeContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public Type visitType(TypeContext ctx) {
		Type type = new Type();
		type.setBaseType(BaseTypeConverter.getInstance().convert(ctx));
		return type;
	}
}
