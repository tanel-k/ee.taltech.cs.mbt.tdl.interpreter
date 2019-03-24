package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.SizeTypeArrayModifier;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class IdentifierVariantConverter extends UtaLanguageBaseVisitor<IdentifierData>
	implements IParseTreeConverter<IdentifierData, IdentifierNameVariantContext>
{
	public static IdentifierVariantConverter getInstance() {
		return INSTANCE;
	}

	private static final IdentifierVariantConverter INSTANCE = new IdentifierVariantConverter();

	private IdentifierVariantConverter() { }

	public static class IdentifierData {
		private IdentifierName identifierName;
		private Collection<AbsArrayModifier> arrayModifiers = new LinkedList<>();

		public IdentifierName getIdentifierName() {
			return identifierName;
		}

		public void setIdentifierName(IdentifierName identifierName) {
			this.identifierName = identifierName;
		}

		public Collection<AbsArrayModifier> getArrayModifiers() {
			return arrayModifiers;
		}
	}

	@Override
	public IdentifierData convert(IdentifierNameVariantContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public IdentifierData visitArrayIdentifier(ArrayIdentifierContext ctx) {
		IdentifierData identifierData = new IdentifierData();
		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(ctx.IDENTIFIER_NAME().getText());
		List<AbsArrayModifier> arrayModifiers = new LinkedList<>();
		if (ctx.arraySizeModifier() != null) {
			for (ArraySizeModifierContext arrayModCtx : ctx.arraySizeModifier()) {
				if (arrayModCtx instanceof ArraySizeFromExpressionContext)
				{
					ArraySizeFromExpressionContext sizeCtx = (ArraySizeFromExpressionContext) arrayModCtx;
					SizeExpressionArrayModifier arrayModifier = new SizeExpressionArrayModifier();
					arrayModifier.setSizeSpecifier(ExpressionConverter.getInstance().convert(sizeCtx.expression()));
					arrayModifiers.add(arrayModifier);
				}
				else if (arrayModCtx instanceof ArraySizeFromTypeContext)
				{
					ArraySizeFromTypeContext sizeCtx = (ArraySizeFromTypeContext) arrayModCtx;
					SizeTypeArrayModifier arrayModifier = new SizeTypeArrayModifier();
					arrayModifier.setSizeSpecifier(TypeConverter.getInstance().convert(sizeCtx.type()));
					arrayModifiers.add(arrayModifier);
				}
			}
		}

		identifierData.setIdentifierName(identifierName);
		identifierData.getArrayModifiers().addAll(arrayModifiers);
		return identifierData;
	}

	@Override
	public IdentifierData visitBaseIdentifier(BaseIdentifierContext ctx) {
		IdentifierData identifierData = new IdentifierData();
		IdentifierName identifierName = new IdentifierName();
		identifierName.setName(ctx.getText());
		identifierData.setIdentifierName(identifierName);
		return identifierData;
	}
}
