package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;

import java.util.Set;

public class ColorCtxExtractor implements IPicklerContextExtractor<Color> {
	public static ColorCtxExtractor getInstance() {
		return new ColorCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Color.class
	);

	private ColorCtxExtractor() { }

	@Override
	public ContextBuilder extract(Color color) {
		return ContextBuilder.newBuilder()
				.put("value", color.getIntValue());
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
