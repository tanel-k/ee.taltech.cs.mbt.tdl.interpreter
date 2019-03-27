package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.FieldDeclaration;

public class TypeIdentifierConverter extends UtaLanguageBaseVisitor<AbsTypeId>
	implements IParseTreeConverter<AbsTypeId, TypeIdentifierContext>
{
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
	public AbsTypeId visitTypeIdInteger(TypeIdIntegerContext ctx) {
		return BaseTypeIdentifiers.INTEGER;
	}

	@Override
	public AbsTypeId visitTypeIdClock(TypeIdClockContext ctx) {
		return BaseTypeIdentifiers.CLOCK;
	}

	@Override
	public AbsTypeId visitTypeIdChannel(TypeIdChannelContext ctx) {
		return BaseTypeIdentifiers.CHANNEL;
	}

	@Override
	public AbsTypeId visitTypeIdBoolean(TypeIdBooleanContext ctx) {
		return BaseTypeIdentifiers.BOOLEAN;
	}

	@Override
	public AbsTypeId visitTypeIdIntegerBounded(TypeIdIntegerBoundedContext ctx) {
		BoundedIntegerTypeId boundedIntegerTypeIdentifier = new BoundedIntegerTypeId();
		boundedIntegerTypeIdentifier.setMaxBoundExpression(
			ExpressionConverter.getInstance().convert(ctx.expression(0))
		);
		boundedIntegerTypeIdentifier.setMinBoundExpression(
			ExpressionConverter.getInstance().convert(ctx.expression(1))
		);
		return boundedIntegerTypeIdentifier;
	}

	@Override
	public AbsTypeId visitTypeIdScalar(TypeIdScalarContext ctx) {
		ScalarTypeId scalarTypeIdentifier = new ScalarTypeId();
		scalarTypeIdentifier.setSizeExpression(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		return scalarTypeIdentifier;
	}

	@Override
	public AbsTypeId visitTypeIdStruct(TypeIdStructContext ctx) {
		StructTypeId structTypeIdentifier = new StructTypeId();

		for (FieldDeclarationContext fieldDeclarationCtx : ctx.fieldDeclaration()) {
			Type<AbsTypeId> type = TypeConverter.getInstance().convert(fieldDeclarationCtx.type());
			for (IdentifierNameVariantContext identifierVariantCtx : fieldDeclarationCtx.identifierNameVariant()) {
				Type<AbsTypeId> typeClone = type.clone();
				IdentifierData identifierData =
					IdentifierVariantConverter.getInstance().convert(identifierVariantCtx);
				typeClone.getArrayModifiers().addAll(identifierData.getArrayModifiers());
				FieldDeclaration<AbsTypeId> fieldDeclaration = new FieldDeclaration<>();
				fieldDeclaration.setType(typeClone);
				fieldDeclaration.setIdentifierName(identifierData.getIdentifierName());
			}
		}

		return structTypeIdentifier;
	}

	@Override
	public AbsTypeId visitTypeIdIdentifierName(TypeIdIdentifierNameContext ctx) {
		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(ctx.IDENTIFIER_NAME().getText());

		IdRefTypeId idRefTypeIdentifier = new IdRefTypeId();
		idRefTypeIdentifier.setIdentifierName(identifierName);

		return idRefTypeIdentifier;
	}
}
