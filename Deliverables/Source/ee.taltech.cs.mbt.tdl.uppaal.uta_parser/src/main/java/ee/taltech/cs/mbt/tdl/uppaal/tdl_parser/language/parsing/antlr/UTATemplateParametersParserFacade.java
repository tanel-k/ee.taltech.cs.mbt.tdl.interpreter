package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.parameters.ParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.template.TemplateParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition.TransitionSelectsConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.generic.AbsUTAParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTemplateParameterListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionSelectionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

import java.util.List;

public class UTATemplateParametersParserFacade
	extends AbsUTAParserFacade<List<ParameterDeclaration<AbsTypeIdentifier>>, UtaTemplateParameterListContext, TemplateParameterListConverter>
{

	@Override
	protected UtaTemplateParameterListContext getRootContext(UTALanguageParser parser) {
		return parser.utaTemplateParameterList();
	}

	@Override
	protected TemplateParameterListConverter getConverter() {
		return new TemplateParameterListConverter();
	}
}
