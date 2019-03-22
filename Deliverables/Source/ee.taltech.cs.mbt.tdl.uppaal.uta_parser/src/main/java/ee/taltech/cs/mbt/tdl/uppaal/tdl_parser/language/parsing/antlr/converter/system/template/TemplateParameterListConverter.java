package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.template;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.parameters.ParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTemplateParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import java.util.List;

public class TemplateParameterListConverter extends UTALanguageBaseVisitor<List<ParameterDeclaration<AbsTypeIdentifier>>>
		implements IParseTreeConverter<List<ParameterDeclaration<AbsTypeIdentifier>>, UtaTemplateParameterListContext>
{
	@Override
	public List<ParameterDeclaration<AbsTypeIdentifier>> convert(UtaTemplateParameterListContext rootContext) throws ParseTreeStructureException {
		ParameterListContext parameterListCtx = rootContext.parameterList();
		return new ParameterListConverter().convert(parameterListCtx);
	}
}
