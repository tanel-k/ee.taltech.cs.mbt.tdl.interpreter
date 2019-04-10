package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.parameter;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.TypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;

import java.util.Set;

public class ParameterCtxExtractor implements IPicklerContextExtractor<ParameterDeclaration> {
	public static ParameterCtxExtractor getInstance() {
		return new ParameterCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Identifier.class,
			ParameterDeclaration.class
	);

	private ParameterCtxExtractor() { }

	@Override
	public ContextBuilder extract(ParameterDeclaration decl) {
		String paramName = decl.getIdentifier().toString();
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance()
				.extract(decl.getType(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("name", paramName)
				.put("identifier", paramName)
				.put("type", typeCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
