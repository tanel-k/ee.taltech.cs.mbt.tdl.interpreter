package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.LocationLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.labels.LabelCtxExtractor;

import java.util.Set;

public class LocationLabelsCtxExtractor implements IPicklerContextExtractor<LocationLabels> {
	public static LocationLabelsCtxExtractor getInstance() {
		return new LocationLabelsCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			LocationLabels.class
	);

	private LocationLabelsCtxExtractor() { }

	@Override
	public ContextBuilder extract(LocationLabels labels) {
		ContextBuilder commentCtx = labels.getCommentLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getCommentLabel(), requiredClasses)
				: null;
		ContextBuilder invariantCtx = labels.getInvariantLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getInvariantLabel(), requiredClasses)
				: null;

		return ContextBuilder.newBuilder()
				.put("invariant", invariantCtx)
				.put("comment", commentCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
