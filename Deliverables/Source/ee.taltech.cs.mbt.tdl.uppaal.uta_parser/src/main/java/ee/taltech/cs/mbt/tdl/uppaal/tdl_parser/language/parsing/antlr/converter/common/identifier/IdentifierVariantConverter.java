package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.SizeTypeArrayModifier;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class IdentifierVariantConverter extends UTALanguageBaseVisitor<IdentifierData>
	implements IParseTreeConverter<IdentifierData, IdentifierNameVariantContext>
{
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
	public IdentifierData convert(IdentifierNameVariantContext rootContext) throws ParseTreeStructureException {
		return rootContext.accept(this);
	}

	@Override
	public IdentifierData visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Identifier variant subtree contains an error node (" + node.getText() + ")."
		);
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
					arrayModifier.setSizeSpecifier(new ExpressionConverter().convert(sizeCtx.expression()));
					arrayModifiers.add(arrayModifier);
				}
				else if (arrayModCtx instanceof ArraySizeFromTypeContext)
				{
					ArraySizeFromTypeContext sizeCtx = (ArraySizeFromTypeContext) arrayModCtx;
					SizeTypeArrayModifier arrayModifier = new SizeTypeArrayModifier();
					arrayModifier.setSizeSpecifier(new TypeConverter().convert(sizeCtx.type()));
					arrayModifiers.add(arrayModifier);
				}
				else
				{
					throw new ParseTreeStructureException(
						"Encountered unrecognized array size modifier " + arrayModCtx.getClass().getName()
					);
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