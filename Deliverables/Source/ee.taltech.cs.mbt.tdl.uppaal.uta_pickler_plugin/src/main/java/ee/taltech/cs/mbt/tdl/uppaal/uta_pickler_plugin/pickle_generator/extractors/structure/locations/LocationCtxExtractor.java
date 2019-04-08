package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;

import java.util.Set;

public class LocationCtxExtractor implements IPicklerContextExtractor<Location> {
	public static LocationCtxExtractor getInstance() {
		return new LocationCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private LocationCtxExtractor() { }

	@Override
	public ContextBuilder extract(Location location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
