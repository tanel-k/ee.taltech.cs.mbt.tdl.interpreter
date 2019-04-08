package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.LocationLabels;

import java.util.Set;

public class LocationLabelsCtxExtractor implements IPicklerContextExtractor<LocationLabels> {
	public static LocationLabelsCtxExtractor getInstance() {
		return new LocationLabelsCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private LocationLabelsCtxExtractor() { }

	@Override
	public ContextBuilder extract(LocationLabels labels) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
