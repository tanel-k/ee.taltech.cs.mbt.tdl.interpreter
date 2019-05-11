package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public interface IPicklerContextExtractor<T> extends IContextExtractor<T> {
	Set<Class> getRequiredClasses();

	default ContextBuilder extract(T inst, Set<Class> requiredClasses) {
		ContextBuilder context = extract(inst);
		requiredClasses.addAll(getRequiredClasses());
		return context;
	}

	default Collection<ContextBuilder> extract(Collection<T> instances, Set<Class> requiredClasses) {
		return extract(instances, new LinkedList<>(), requiredClasses);
	}

	default Collection<ContextBuilder> extract(Collection<T> instances, Collection<ContextBuilder> to, Set<Class> requiredClasses) {
		Collection<ContextBuilder> contexts = extract(instances, to);
		requiredClasses.addAll(getRequiredClasses());
		return contexts;
	}
}
