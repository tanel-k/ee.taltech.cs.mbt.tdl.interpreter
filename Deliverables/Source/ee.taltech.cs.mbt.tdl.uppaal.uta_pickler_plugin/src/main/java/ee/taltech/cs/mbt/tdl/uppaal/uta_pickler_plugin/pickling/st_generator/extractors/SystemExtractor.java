package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Set;

public class SystemExtractor implements IPicklerContextExtractor<UtaSystem> {
	public static SystemExtractor getInstance() {
		return new SystemExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private SystemExtractor() { }

	@Override
	public ContextBuilder extract(UtaSystem inst) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
