package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ByReferenceVariableContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ByValueVariableContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.IdentifierNameVariantContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ParameterIdentifierContext;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.ParameterIdentifierConverter.ParameterIdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.AbsArrayModifier;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.Collection;
import java.util.LinkedList;

public class ParameterIdentifierConverter
	extends UTALanguageBaseVisitor<ParameterIdentifierData>
	implements IParseTreeConverter<ParameterIdentifierData, ParameterIdentifierContext>
{
	public static class ParameterIdentifierData {
		private boolean byReference;
		private IdentifierName identifierName;
		private Collection<AbsArrayModifier> arrayModifiers = new LinkedList<>();

		public boolean isByReference() {
			return byReference;
		}

		public void setByReference(boolean byReference) {
			this.byReference = byReference;
		}

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
	public ParameterIdentifierData convert(ParameterIdentifierContext rootContext) throws ParseTreeStructureException {
		return rootContext.accept(this);
	}

	@Override
	public ParameterIdentifierData visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Parameter identifier subtree contains an error node (" + node.getText() + ")."
		);
	}

	@Override
	public ParameterIdentifierData visitByValueVariable(ByValueVariableContext ctx)
	{
		ParameterIdentifierData result = visitIdentifierNameVariant(ctx.identifierNameVariant());
		result.setByReference(false);
		return result;
	}

	@Override
	public ParameterIdentifierData visitByReferenceVariable(ByReferenceVariableContext ctx)
	{
		ParameterIdentifierData result = visitIdentifierNameVariant(ctx.identifierNameVariant());
		result.setByReference(true);
		return result;
	}

	private ParameterIdentifierData visitIdentifierNameVariant(
		IdentifierNameVariantContext identifierNameVariantContext) {
		IdentifierData identifierData = new IdentifierVariantConverter().convert(identifierNameVariantContext);
		ParameterIdentifierData parameterIdentifierData = new ParameterIdentifierData();
		parameterIdentifierData.setIdentifierName(identifierData.getIdentifierName());
		parameterIdentifierData.getArrayModifiers().addAll(identifierData.getArrayModifiers());
		return parameterIdentifierData;
	}
}
