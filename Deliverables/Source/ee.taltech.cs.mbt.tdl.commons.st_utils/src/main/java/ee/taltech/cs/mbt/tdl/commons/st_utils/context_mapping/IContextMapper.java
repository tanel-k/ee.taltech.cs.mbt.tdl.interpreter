package ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping;

import java.util.Collection;
import java.util.LinkedList;

public interface IContextMapper<T> {
	default ContextBuilder map(T inst) {
		return newBuilder();
	}

	default Collection<ContextBuilder> map(Collection<T> instances) {
		return map(instances, new LinkedList<>());
	}

	default Collection<ContextBuilder> map(Collection<T> instances, Collection<ContextBuilder> to) {
		if (instances == null)
			return to;
		instances.stream().map(this::map).forEach(to::add);
		return to;
	}

	default ContextBuilder newBuilder() {
		return ContextBuilder.newBuilder();
	}
}
