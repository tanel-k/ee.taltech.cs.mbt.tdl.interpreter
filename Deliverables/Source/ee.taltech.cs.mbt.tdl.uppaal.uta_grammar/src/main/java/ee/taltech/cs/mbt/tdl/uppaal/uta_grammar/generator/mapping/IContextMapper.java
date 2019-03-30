package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;

import java.util.Collection;
import java.util.LinkedList;

public interface IContextMapper<T> {
	default ContextBuilder map(T inst) {
		return newBuilder();
	}

	default Collection<ContextBuilder> mapCollection(Collection<T> instances, Collection<ContextBuilder> to) {
		if (instances == null)
			return to;
		instances.stream().map(this::map).forEach(to::add);
		return to;
	}

	default Collection<ContextBuilder> mapCollection(Collection<T> instances) {
		return mapCollection(instances, new LinkedList<>());
	}

	default ContextBuilder newBuilder() {
		return ContextBuilder.newBuilder();
	}
}
