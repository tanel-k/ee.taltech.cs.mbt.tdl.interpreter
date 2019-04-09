package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.system.SystemDefinitionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.templates.TemplateCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Collection;
import java.util.Set;

public class SystemExtractor implements IPicklerContextExtractor<UtaSystem> {
	public static SystemExtractor getInstance() {
		return new SystemExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
		UtaSystem.class
	);

	private SystemExtractor() { }

	@Override
	public ContextBuilder extract(UtaSystem system) {
		Collection<ContextBuilder> declCtxs = DeclarationCtxExtractor.getInstance()
				.extract(system.getGlobalDeclarations(), requiredClasses);
		Collection<ContextBuilder> templateCtxs = TemplateCtxExtractor.getInstance()
				.extract(system.getTemplates(), requiredClasses);
		ContextBuilder systemDefinitionCtx = system.getSystemDefinition() != null
				? SystemDefinitionCtxExtractor.getInstance().extract(system.getSystemDefinition(), requiredClasses)
				: null;
		return ContextBuilder.newBuilder()
				.put("declarations", declCtxs)
				.put("templates", templateCtxs)
				.put("systemDefinition", systemDefinitionCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
