package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui.ColorCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui.GuiCoordinatesCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.ELocationExitPolicy;

import java.util.Set;

public class LocationCtxExtractor implements IPicklerContextExtractor<Location> {
	public static LocationCtxExtractor getInstance() {
		return new LocationCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Location.class,
			ELocationExitPolicy.class
	);

	private LocationCtxExtractor() { }

	@Override
	public ContextBuilder extract(Location location) {
		ContextBuilder nameCtx = location.getName() != null
				? LocationNameCtxExtractor.getInstance().extract(location.getName(), requiredClasses)
				: null;
		ContextBuilder colorCtx = location.getColor() != null
				? ColorCtxExtractor.getInstance().extract(location.getColor(), requiredClasses)
				: null;
		ContextBuilder coordCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(location.getCoordinates(), requiredClasses);
		ContextBuilder labelsCtx = LocationLabelsCtxExtractor.getInstance()
				.extract(location.getLabels(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("id", location.getId())
				.put("name", nameCtx)
				.put("exitPolicy",
						ContextBuilder.newBuilder()
								.put("committed", location.getExitPolicy() == ELocationExitPolicy.COMMITTED)
								.put("urgent", location.getExitPolicy() == ELocationExitPolicy.URGENT)
				)
				.put("labels", labelsCtx)
				.put("color", colorCtx)
				.put("coordinates", coordCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
