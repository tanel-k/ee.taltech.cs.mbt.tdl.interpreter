package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.system.SystemDefinitionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;

import java.util.Optional;

public class SystemDefinitionGenerator extends AbsSTGenerator<SystemDefinition> {
	private static final String TEMPLATE_NAME = "systemDefinition";

	SystemDefinitionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextMapper<SystemDefinition> getContextMapper() {
		return SystemDefinitionMapper.getInstance();
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.empty();
	}
}
