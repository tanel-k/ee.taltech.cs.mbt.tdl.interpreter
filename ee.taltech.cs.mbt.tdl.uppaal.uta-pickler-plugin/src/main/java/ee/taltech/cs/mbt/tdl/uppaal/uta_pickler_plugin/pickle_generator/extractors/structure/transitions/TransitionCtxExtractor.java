package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.transitions;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.strings.WordUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui.ColorCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui.GuiCoordinatesCtxExtractor;

import java.util.Collection;
import java.util.Set;

public class TransitionCtxExtractor implements IPicklerContextExtractor<Transition> {
	public static TransitionCtxExtractor getInstance() {
		return new TransitionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Transition.class
	);

	private TransitionCtxExtractor() { }

	@Override
	public ContextBuilder extract(Transition transition) {
		String sourceId = transition.getSource().getId();
		String targetId = transition.getTarget().getId();
		String name = WordUtils.capitalize(sourceId) + "To" + WordUtils.capitalize(targetId);

		ContextBuilder labels = TransitionLabelsCtxExtractor.getInstance()
				.extract(transition.getLabels(), requiredClasses);
		Collection<ContextBuilder> nailCtxs = GuiCoordinatesCtxExtractor.getInstance()
				.extract(transition.getNails(), requiredClasses);
		ContextBuilder colorCtx = transition.getColor() != null
				? ColorCtxExtractor.getInstance().extract(transition.getColor())
				: null;

		return ContextBuilder.newBuilder()
				.put("name", name)
				.put("sourceId", sourceId)
				.put("targetId", targetId)
				.put("color", colorCtx)
				.put("labels", labels)
				.put("nails", nailCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
