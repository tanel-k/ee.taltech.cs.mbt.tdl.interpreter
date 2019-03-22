package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.FieldDeclaration;

public class TypeIdentifierConverter extends UTALanguageBaseVisitor<AbsTypeIdentifier>
	implements IParseTreeConverter<AbsTypeIdentifier, TypeIdentifierContext> {
	@Override
	public AbsTypeIdentifier convert(TypeIdentifierContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsTypeIdentifier visitTypeIdInteger(TypeIdIntegerContext ctx) {
		return BaseTypeIdentifiers.INTEGER;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdClock(TypeIdClockContext ctx) {
		return BaseTypeIdentifiers.CLOCK;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdChannel(TypeIdChannelContext ctx) {
		return BaseTypeIdentifiers.CHANNEL;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdBoolean(TypeIdBooleanContext ctx) {
		return BaseTypeIdentifiers.BOOLEAN;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdIntegerBounded(TypeIdIntegerBoundedContext ctx) {
		BoundedIntegerTypeIdentifier boundedIntegerTypeIdentifier = new BoundedIntegerTypeIdentifier();
		boundedIntegerTypeIdentifier.setMaxBoundExpression(
			new ExpressionConverter().convert(ctx.expression(0))
		);
		boundedIntegerTypeIdentifier.setMinBoundExpression(
			new ExpressionConverter().convert(ctx.expression(1))
		);
		return boundedIntegerTypeIdentifier;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdScalar(TypeIdScalarContext ctx) {
		ScalarTypeIdentifier scalarTypeIdentifier = new ScalarTypeIdentifier();
		scalarTypeIdentifier.setSizeExpression(
			new ExpressionConverter().convert(ctx.expression())
		);
		return scalarTypeIdentifier;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdStruct(TypeIdStructContext ctx) {
		StructTypeIdentifier structTypeIdentifier = new StructTypeIdentifier();

		for (FieldDeclarationContext fieldDeclarationCtx : ctx.fieldDeclaration()) {
			Type<AbsTypeIdentifier> type = new TypeConverter().convert(fieldDeclarationCtx.type());
			for (IdentifierNameVariantContext identifierVariantCtx : fieldDeclarationCtx.identifierNameVariant()) {
				Type<AbsTypeIdentifier> typeClone = type.clone();
				IdentifierData identifierData =
					new IdentifierVariantConverter().convert(identifierVariantCtx);
				typeClone.getArrayModifiers().addAll(identifierData.getArrayModifiers());
				FieldDeclaration<AbsTypeIdentifier> fieldDeclaration = new FieldDeclaration<>();
				fieldDeclaration.setType(typeClone);
				fieldDeclaration.setIdentifierName(identifierData.getIdentifierName());
			}
		}

		return structTypeIdentifier;
	}

	@Override
	public AbsTypeIdentifier visitTypeIdIdentifierName(TypeIdIdentifierNameContext ctx) {
		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(ctx.IDENTIFIER_NAME().getText());

		IdRefTypeIdentifier idRefTypeIdentifier = new IdRefTypeIdentifier();
		idRefTypeIdentifier.setIdentifierName(identifierName);

		return idRefTypeIdentifier;
	}
}
