package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.template;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.parameters.ParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.UtaTemplateParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;

import java.util.List;

public class TemplateParameterListConverter extends UtaLanguageBaseVisitor<List<ParameterDeclaration>>
	implements IParseTreeConverter<List<ParameterDeclaration>, UtaTemplateParameterListContext>
{
	public static TemplateParameterListConverter getInstance() {
		return INSTANCE;
	}

	private static final TemplateParameterListConverter INSTANCE = new TemplateParameterListConverter();

	private TemplateParameterListConverter() { }

	@Override
	public List<ParameterDeclaration> convert(UtaTemplateParameterListContext rootContext) {
		ParameterListContext parameterListCtx = rootContext.parameterList();
		return ParameterListConverter.getInstance().convert(parameterListCtx);
	}
}
