package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.parameter;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;

import java.util.Set;

public class ParameterCtxExtractor implements IPicklerContextExtractor<ParameterDeclaration> {
	public static ParameterCtxExtractor getInstance() {
		return new ParameterCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private ParameterCtxExtractor() { }

	@Override
	public ContextBuilder extract(ParameterDeclaration decl) {
		return null;
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
