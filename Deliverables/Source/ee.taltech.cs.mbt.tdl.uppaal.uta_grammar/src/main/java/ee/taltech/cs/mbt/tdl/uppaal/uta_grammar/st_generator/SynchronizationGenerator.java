package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.template.SynchronizationMapper;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

import java.util.Optional;

public class SynchronizationGenerator extends AbsSTGenerator<Synchronization> {
	private static final String TEMPLATE_NAME = "synchronization";

	SynchronizationGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextMapper<Synchronization> getContextMapper() {
		return SynchronizationMapper.getInstance();
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
