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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.struct.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.struct.StructTypeId;

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
			ExpressionConverter.getInstance().convert(ctx.expression(0))
		);
		boundedIntegerTypeIdentifier.setMinimumBound(
			ExpressionConverter.getInstance().convert(ctx.expression(1))
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
			for (IdentifierDeclarationContext identifierDeclarationContext : fieldDeclarationCtx.identifierDeclaration()) {
				Type<?> typeClone = TypeConverter.getInstance().convert(fieldDeclarationCtx.type());
				IdentifierData identifierData = IdentifierDeclarationConverter
					.getInstance()
					.convert(identifierDeclarationContext);
				typeClone.getArrayModifiers().addAll(identifierData.getArrayModifiers());

				FieldDeclaration fieldDeclaration = new FieldDeclaration();
				fieldDeclaration.setType(typeClone);
				fieldDeclaration.setIdentifier(identifierData.getIdentifier());
			}
		}

		return structTypeIdentifier;
	}

	@Override
	public AbsTypeId visitCustomTypeId(CustomTypeIdContext ctx) {
		Identifier identifier = new Identifier();
		identifier.setText(ctx.IDENTIFIER_NAME().getText());

		CustomTypeId customTypeIdentifier = new CustomTypeId();
		customTypeIdentifier.setIdentifier(identifier);

		return customTypeIdentifier;
	}
}
