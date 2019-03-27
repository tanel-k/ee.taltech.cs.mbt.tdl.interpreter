package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.parameters;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.ParameterIdentifierConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.ParameterIdentifierConverter.ParameterIdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.parameter.ParameterDeclaration;

import java.util.LinkedList;
import java.util.List;

public class ParameterListConverter extends UtaLanguageBaseVisitor<List<ParameterDeclaration>>
	implements IParseTreeConverter<List<ParameterDeclaration>, ParameterListContext> {

	private static final ParameterListConverter INSTANCE = new ParameterListConverter();

	public static ParameterListConverter getInstance() {
		return INSTANCE;
	}

	private ParameterListConverter() { }

	@Override
	public List<ParameterDeclaration> convert(ParameterListContext rootContext) {
		List<ParameterDeclaration> parameterDeclarations = new LinkedList<>();
		for (ParameterContext parameterCtx : rootContext.parameter()) {
			Type<AbsTypeId> parameterType = TypeConverter.getInstance()
					.convert(parameterCtx.type());
			ParameterIdentifierData paramData = ParameterIdentifierConverter.getInstance()
					.convert(parameterCtx.parameterIdentifier());
			parameterType.getArrayModifiers().addAll(paramData.getArrayModifiers());
			parameterType.setReferenceType(paramData.isByReference());

			ParameterDeclaration<AbsTypeId> parameterDeclaration = new ParameterDeclaration<>();
			parameterDeclaration.setIdentifierName(paramData.getIdentifierName());
			parameterDeclaration.setType(parameterType);
			parameterDeclarations.add(parameterDeclaration);
		}
		return parameterDeclarations;
	}
}
