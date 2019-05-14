package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.system.SystemDefinitionCtxExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;

import java.util.Optional;

public class SystemDefinitionGenerator extends AbsSTGenerator<SystemDefinition> {
	private static final String TEMPLATE_NAME = "systemDefinition";

	SystemDefinitionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<SystemDefinition> getContextExtractor() {
		return SystemDefinitionCtxExtractor.getInstance();
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
