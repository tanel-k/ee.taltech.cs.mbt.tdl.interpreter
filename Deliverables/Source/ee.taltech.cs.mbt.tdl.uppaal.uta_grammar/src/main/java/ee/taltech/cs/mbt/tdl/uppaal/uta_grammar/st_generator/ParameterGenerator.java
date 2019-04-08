package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.parameter.ParameterMapper;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;

import java.util.Optional;

public class ParameterGenerator extends AbsSTGenerator<ParameterDeclaration> {
	private static final String TEMPLATE_NAME = "parameter";
	private static final String ITERABLE_TEMPLATE_NAME = "parameters";

	ParameterGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextMapper<ParameterDeclaration> getContextMapper() {
		return ParameterMapper.getInstance();
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.of(ITERABLE_TEMPLATE_NAME);
	}
}
