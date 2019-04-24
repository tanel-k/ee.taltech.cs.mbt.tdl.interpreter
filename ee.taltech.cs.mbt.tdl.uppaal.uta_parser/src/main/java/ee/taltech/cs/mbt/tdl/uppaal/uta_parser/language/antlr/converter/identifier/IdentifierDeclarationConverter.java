package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.identifier;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.identifier.IdentifierDeclarationConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.type.BaseTypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ArrayIdentifierDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ArraySizeModifierContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.BaseIdentifierDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionArraySizeModifierContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.IdentifierDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeArraySizeModifierContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeTypeArrayModifier;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class IdentifierDeclarationConverter extends UtaLanguageBaseVisitor<IdentifierData>
		implements IParseTreeConverter<IdentifierData, IdentifierDeclarationContext> {
	public static IdentifierDeclarationConverter getInstance() {
		return INSTANCE;
	}

	private static final IdentifierDeclarationConverter INSTANCE = new IdentifierDeclarationConverter();

	private IdentifierDeclarationConverter() { }

	public static class IdentifierData {
		private Identifier identifier;
		private Collection<AbsArrayModifier> arrayModifiers = new LinkedList<>();

		public Identifier getIdentifier() {
			return identifier;
		}

		public void setIdentifier(Identifier identifier) {
			this.identifier = identifier;
		}

		public Collection<AbsArrayModifier> getArrayModifiers() {
			return arrayModifiers;
		}
	}

	@Override
	public IdentifierData convert(IdentifierDeclarationContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public IdentifierData visitArrayIdentifierDeclaration(ArrayIdentifierDeclarationContext ctx) {
		IdentifierData identifierData = new IdentifierData();
		Identifier identifier = Identifier.of(ctx.IDENTIFIER_NAME().getText());

		List<AbsArrayModifier> arrayModifiers = new LinkedList<>();
		if (ctx.arraySizeModifier() != null) {
			for (ArraySizeModifierContext arrayModCtx : ctx.arraySizeModifier()) {
				if (arrayModCtx instanceof ExpressionArraySizeModifierContext) {
					ExpressionArraySizeModifierContext sizeCtx = (ExpressionArraySizeModifierContext) arrayModCtx;
					SizeExpressionArrayModifier arrayModifier = new SizeExpressionArrayModifier();
					arrayModifier.setSizeSpecifier(ExpressionConverter.getInstance().convert(sizeCtx.expression()));
					arrayModifiers.add(arrayModifier);
				} else if (arrayModCtx instanceof TypeArraySizeModifierContext)
				{
					TypeArraySizeModifierContext sizeCtx = (TypeArraySizeModifierContext) arrayModCtx;
					SizeTypeArrayModifier arrayModifier = new SizeTypeArrayModifier();
					arrayModifier.setSizeSpecifier(BaseTypeConverter.getInstance().convert(sizeCtx.type()));
					arrayModifiers.add(arrayModifier);
				}
			}
		}

		identifierData.setIdentifier(identifier);
		identifierData.getArrayModifiers().addAll(arrayModifiers);
		return identifierData;
	}

	@Override
	public IdentifierData visitBaseIdentifierDeclaration(BaseIdentifierDeclarationContext ctx) {
		IdentifierData identifierData = new IdentifierData();
		Identifier identifier = Identifier.of(ctx.getText());
		identifierData.setIdentifier(identifier);
		return identifierData;
	}
}
