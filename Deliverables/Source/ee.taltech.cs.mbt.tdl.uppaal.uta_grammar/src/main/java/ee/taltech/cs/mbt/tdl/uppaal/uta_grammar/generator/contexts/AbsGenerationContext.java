package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.contexts;

import java.util.HashMap;
import java.util.Map;

public abstract class AbsGenerationContext {
	private Map<String, Object> contextMap = new HashMap<>();

	public Map<String, Object> getContextMap() {
		return contextMap;
	}
}
