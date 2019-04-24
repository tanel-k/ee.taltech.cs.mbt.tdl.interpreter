package ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ContextBuilder {
	public static ContextBuilder newBuilder(String name) {
		return new ContextBuilder().put(name, true);
	}

	public static ContextBuilder newBuilder() {
		return new ContextBuilder();
	}

	private Map<String, Object> map = new HashMap<>();

	private ContextBuilder() { }

	public ContextBuilder put(String key, Object value) {
		map.put(key, value);
		return this;
	}

	public ContextBuilder put(String key, ContextBuilder builder) {
		return put(
				key,
				builder == null
						? null
						: builder.getContextMap()
		);
	}

	public ContextBuilder put(String key, Collection<ContextBuilder> builders) {
		if (builders == null)
			return this;

		return put(
				key,
				builders.stream()
					.map(ContextBuilder::getContextMap)
					.collect(Collectors.toList())
		);
	}

	public Map<String, Object> getContextMap() {
		return map;
	}
}
