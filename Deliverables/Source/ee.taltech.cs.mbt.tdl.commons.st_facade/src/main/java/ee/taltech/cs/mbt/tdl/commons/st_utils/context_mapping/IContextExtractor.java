package ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping;

import java.util.Collection;
import java.util.LinkedList;

public interface IContextExtractor<T> {
	default ContextBuilder extract(T inst) {
		return newBuilder();
	}

	default Collection<ContextBuilder> extract(Collection<T> instances) {
		return extract(instances, new LinkedList<>());
	}

	default Collection<ContextBuilder> extract(Collection<T> instances, Collection<ContextBuilder> to) {
		if (instances == null)
			return to;
		instances.stream().map(this::extract).forEach(to::add);
		return to;
	}

	default ContextBuilder newBuilder() {
		return ContextBuilder.newBuilder();
	}
}
