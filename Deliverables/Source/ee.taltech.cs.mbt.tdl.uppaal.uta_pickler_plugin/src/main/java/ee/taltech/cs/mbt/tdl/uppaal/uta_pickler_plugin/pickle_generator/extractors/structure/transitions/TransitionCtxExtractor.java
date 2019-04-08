package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.transitions;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Set;

public class TransitionCtxExtractor implements IPicklerContextExtractor<Transition> {
	public static TransitionCtxExtractor getInstance() {
		return new TransitionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private TransitionCtxExtractor() { }

	@Override
	public ContextBuilder extract(Transition transition) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
