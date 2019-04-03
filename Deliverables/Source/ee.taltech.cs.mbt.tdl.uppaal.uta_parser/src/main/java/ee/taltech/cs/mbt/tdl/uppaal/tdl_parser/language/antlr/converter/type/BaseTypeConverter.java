package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.type;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;

public class BaseTypeConverter extends UtaLanguageBaseVisitor<BaseType>
		implements IParseTreeConverter<BaseType, TypeContext> {
	public static BaseTypeConverter getInstance() {
		return INSTANCE;
	}

	private static final BaseTypeConverter INSTANCE = new BaseTypeConverter();

	private BaseTypeConverter() { }

	@Override
	public BaseType convert(TypeContext ctx) {
		BaseType baseType = new BaseType();
		baseType.setPrefix(TypePrefixConverter.getInstance().convert(ctx.typePrefix()));
		baseType.setTypeId(TypeIdentifierConverter.getInstance().convert(ctx.typeIdentifier()));
		return baseType;
	}
}
