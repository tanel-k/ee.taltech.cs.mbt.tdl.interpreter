package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.transitions;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.TransitionLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.labels.LabelCtxExtractor;

import java.util.Set;

public class TransitionLabelsCtxExtractor implements IPicklerContextExtractor<TransitionLabels> {
	public static TransitionLabelsCtxExtractor getInstance() {
		return new TransitionLabelsCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			TransitionLabels.class
	);

	private TransitionLabelsCtxExtractor() { }

	@Override
	public ContextBuilder extract(TransitionLabels labels) {
		ContextBuilder assignmentsCtx = labels.getAssignmentsLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getAssignmentsLabel(), requiredClasses)
				: null;
		ContextBuilder commentCtx = labels.getCommentLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getCommentLabel(), requiredClasses)
				: null;
		ContextBuilder guardCtx = labels.getGuardLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getGuardLabel(), requiredClasses)
				: null;
		ContextBuilder selectionCtx = labels.getSelectionLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getSelectionLabel(), requiredClasses)
				: null;
		ContextBuilder synchronizationCtx = labels.getSynchronizationLabel() != null
				? LabelCtxExtractor.getInstance().extract(labels.getSynchronizationLabel(), requiredClasses)
				: null;

		return ContextBuilder.newBuilder()
				.put("assignments", assignmentsCtx)
				.put("comment", commentCtx)
				.put("guard", guardCtx)
				.put("selection", selectionCtx)
				.put("synchronization", synchronizationCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
