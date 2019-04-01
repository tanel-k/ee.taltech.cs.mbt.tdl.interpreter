package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.BooleanTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.BoundedIntegerTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ClockTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.CustomTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.FieldDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.IdentifierDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.IntegerTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ScalarTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.StructTypeIdContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeIdentifierContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.StructTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap;

import java.util.Collection;

public class TypeIdentifierConverter extends UtaLanguageBaseVisitor<AbsTypeId>
		implements IParseTreeConverter<AbsTypeId, TypeIdentifierContext> {
	public static TypeIdentifierConverter getInstance() {
		return INSTANCE;
	}

	private static final TypeIdentifierConverter INSTANCE = new TypeIdentifierConverter();

	private TypeIdentifierConverter() { }

	@Override
	public AbsTypeId convert(TypeIdentifierContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsTypeId visitIntegerTypeId(IntegerTypeIdContext ctx) {
		return BaseTypeIdentifiers.INTEGER;
	}

	@Override
	public AbsTypeId visitClockTypeId(ClockTypeIdContext ctx) {
		return BaseTypeIdentifiers.CLOCK;
	}

	@Override
	public AbsTypeId visitChannelTypeId(ChannelTypeIdContext ctx) {
		return BaseTypeIdentifiers.CHANNEL;
	}

	@Override
	public AbsTypeId visitBooleanTypeId(BooleanTypeIdContext ctx) {
		return BaseTypeIdentifiers.BOOLEAN;
	}

	@Override
	public AbsTypeId visitBoundedIntegerTypeId(BoundedIntegerTypeIdContext ctx) {
		BoundedIntegerTypeId boundedIntegerTypeIdentifier = new BoundedIntegerTypeId();
		boundedIntegerTypeIdentifier.setMaximumBound(
			ExpressionConverter.getInstance().convert(ctx.expression(1))
		);
		boundedIntegerTypeIdentifier.setMinimumBound(
			ExpressionConverter.getInstance().convert(ctx.expression(0))
		);
		return boundedIntegerTypeIdentifier;
	}

	@Override
	public AbsTypeId visitScalarTypeId(ScalarTypeIdContext ctx) {
		ScalarTypeId scalarTypeIdentifier = new ScalarTypeId();
		scalarTypeIdentifier.setSizeExpression(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		return scalarTypeIdentifier;
	}

	@Override
	public AbsTypeId visitStructTypeId(StructTypeIdContext ctx) {
		StructTypeId structTypeIdentifier = new StructTypeId();

		for (FieldDeclarationContext fieldDeclarationCtx : ctx.fieldDeclaration()) {
			FieldDeclarationGroup multiDeclaration = new FieldDeclarationGroup();
			BaseTypeExtensionMap baseTypeExtensionMap = multiDeclaration.getBaseTypeExtensionMap();
			baseTypeExtensionMap.setBaseType(
					BaseTypeConverter.getInstance().convert(fieldDeclarationCtx.type())
			);

			for (IdentifierDeclarationContext identifierDeclarationContext : fieldDeclarationCtx.identifierDeclaration()) {
				IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
					.convert(identifierDeclarationContext);
				Identifier identifier = identifierData.getIdentifier();
				Collection<AbsArrayModifier> arrayModifiers = identifierData.getArrayModifiers();

				baseTypeExtensionMap.getOrCreateType(identifier);
				baseTypeExtensionMap.getType(identifierData.getIdentifier()).getArrayModifiers().addAll(arrayModifiers);
			}

			structTypeIdentifier.getFieldDeclarations().add(multiDeclaration.reduceToOnlyEntryIfApplicable());
		}

		return structTypeIdentifier;
	}

	@Override
	public AbsTypeId visitCustomTypeId(CustomTypeIdContext ctx) {
		Identifier identifier = Identifier.of(ctx.IDENTIFIER_NAME().getText());
		CustomTypeId customTypeIdentifier = new CustomTypeId();
		customTypeIdentifier.setIdentifier(identifier);
		return customTypeIdentifier;
	}
}