package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;

import java.util.Collection;
import java.util.Set;

public interface IPicklerContextExtractor<T> extends IContextExtractor<T> {
	Set<Class> getRequiredClasses();

	default ContextBuilder extract(T inst, Set<Class> requiredClasses) {
		requiredClasses.addAll(getRequiredClasses());
		return extract(inst);
	}

	default Collection<ContextBuilder> extract(Collection<T> instances, Set<Class> requiredClasses) {
		requiredClasses.addAll(getRequiredClasses());
		return extract(instances);
	}

	default Collection<ContextBuilder> extract(Collection<T> instances, Collection<ContextBuilder> to, Set<Class> requiredClasses) {
		requiredClasses.addAll(getRequiredClasses());
		return extract(instances, to);
	}
}
