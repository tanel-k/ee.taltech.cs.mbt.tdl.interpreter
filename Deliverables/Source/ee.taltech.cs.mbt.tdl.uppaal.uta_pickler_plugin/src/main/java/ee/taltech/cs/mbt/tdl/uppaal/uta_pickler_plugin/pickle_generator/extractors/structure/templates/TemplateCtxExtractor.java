package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.templates;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.Set;

public class TemplateCtxExtractor implements IPicklerContextExtractor<Template> {
	public static TemplateCtxExtractor getInstance() {
		return new TemplateCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private TemplateCtxExtractor() { }

	@Override
	public ContextBuilder extract(Template template) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
