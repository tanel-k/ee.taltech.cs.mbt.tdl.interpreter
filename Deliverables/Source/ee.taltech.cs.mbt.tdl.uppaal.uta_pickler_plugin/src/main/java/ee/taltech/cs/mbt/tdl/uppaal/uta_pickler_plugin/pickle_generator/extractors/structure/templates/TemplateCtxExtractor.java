package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.templates;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.parameter.ParameterCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations.LocationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.transitions.TransitionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.Collection;
import java.util.Set;

public class TemplateCtxExtractor implements IPicklerContextExtractor<Template> {
	public static TemplateCtxExtractor getInstance() {
		return new TemplateCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Template.class,
			Identifier.class
	);

	private TemplateCtxExtractor() { }

	@Override
	public ContextBuilder extract(Template template) {
		Collection<ContextBuilder> parameterCtxs = ParameterCtxExtractor.getInstance()
				.extract(template.getParameters(), requiredClasses);
		Collection<ContextBuilder> declarationCtxs = DeclarationCtxExtractor.getInstance()
				.extract(template.getLocalDeclarations(), requiredClasses);
		Collection<ContextBuilder> locationCtxs = LocationCtxExtractor.getInstance()
				.extract(template.getLocationGraph().getVertices(), requiredClasses);
		Collection<ContextBuilder> transitionCtxs = TransitionCtxExtractor.getInstance()
				.extract(template.getLocationGraph().getEdges(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("name", template.getName())
				.put("parameters", parameterCtxs)
				.put("declarations", declarationCtxs)
				.put("locations", locationCtxs)
				.put("transitions", transitionCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
