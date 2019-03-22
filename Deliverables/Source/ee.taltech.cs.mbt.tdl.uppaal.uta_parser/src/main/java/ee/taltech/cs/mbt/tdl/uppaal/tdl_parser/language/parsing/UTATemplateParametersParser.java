package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UTATemplateParametersParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;

import java.util.List;

public class UTATemplateParametersParser extends AbsParser<UTATemplateParametersParserFacade, List<ParameterDeclaration<AbsTypeIdentifier>>> {
	@Override
	protected UTATemplateParametersParserFacade constructFacade() {
		return new UTATemplateParametersParserFacade();
	}
}
