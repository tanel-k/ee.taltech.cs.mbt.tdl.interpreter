package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui.GuiCoordinatesCtxExtractor;

import java.util.Set;

public class LocationNameCtxExtractor implements IPicklerContextExtractor<LocationName> {
	public static LocationNameCtxExtractor getInstance() {
		return new LocationNameCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			LocationName.class
	);

	private LocationNameCtxExtractor() { }

	@Override
	public ContextBuilder extract(LocationName locationName) {
		ContextBuilder coordsCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(locationName.getCoordinates(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("value", locationName.getName())
				.put("coordinates", coordsCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
