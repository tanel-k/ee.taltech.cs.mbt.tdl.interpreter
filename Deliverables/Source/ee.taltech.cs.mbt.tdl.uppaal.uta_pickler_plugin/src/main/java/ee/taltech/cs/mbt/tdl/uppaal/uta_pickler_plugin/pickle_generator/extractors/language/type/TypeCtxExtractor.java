package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

import java.util.Set;

public class TypeCtxExtractor implements IPicklerContextExtractor<Type> {
	public static TypeCtxExtractor getInstance() {
		return new TypeCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private TypeCtxExtractor() { }

	@Override
	public ContextBuilder extract(Type type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
