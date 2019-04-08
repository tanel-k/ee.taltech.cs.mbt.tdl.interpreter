package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.system;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;

import java.util.Set;

public class SystemDefinitionCtxExtractor implements IPicklerContextExtractor<SystemDefinition> {
	public static SystemDefinitionCtxExtractor getInstance() {
		return new SystemDefinitionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private SystemDefinitionCtxExtractor() { }

	@Override
	public ContextBuilder extract(SystemDefinition systemDefinition) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
