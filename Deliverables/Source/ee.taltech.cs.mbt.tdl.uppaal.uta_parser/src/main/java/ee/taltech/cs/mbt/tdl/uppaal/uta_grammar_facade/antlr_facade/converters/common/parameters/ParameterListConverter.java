package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.parameters;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ParameterContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.identifier.ParameterIdentifierConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.identifier.ParameterIdentifierConverter.ParameterIdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ParameterListConverter extends UTALanguageBaseVisitor<Collection<ParameterDeclaration<AbsTypeIdentifier>>>
	implements IParseTreeConverter<Collection<ParameterDeclaration<AbsTypeIdentifier>>, ParameterListContext> {

	@Override
	public Collection<ParameterDeclaration<AbsTypeIdentifier>> convert(
		ParameterListContext rootContext) throws ParseTreeStructureException
	{
		List<ParameterDeclaration<AbsTypeIdentifier>> parameterDeclarations = new LinkedList<>();
		for (ParameterContext parameterCtx : rootContext.parameter()) {
			Type<AbsTypeIdentifier> parameterType = new TypeConverter()
					.convert(parameterCtx.type());
			ParameterIdentifierData paramData = new ParameterIdentifierConverter()
					.convert(parameterCtx.parameterIdentifier());
			parameterType.getArrayModifiers().addAll(paramData.getArrayModifiers());
			parameterType.setReferenceType(paramData.isByReference());

			ParameterDeclaration<AbsTypeIdentifier> parameterDeclaration = new ParameterDeclaration<>();
			parameterDeclaration.setIdentifierName(paramData.getIdentifierName());
			parameterDeclaration.setType(parameterType);
			parameterDeclarations.add(parameterDeclaration);
		}

		return parameterDeclarations;
	}
}
