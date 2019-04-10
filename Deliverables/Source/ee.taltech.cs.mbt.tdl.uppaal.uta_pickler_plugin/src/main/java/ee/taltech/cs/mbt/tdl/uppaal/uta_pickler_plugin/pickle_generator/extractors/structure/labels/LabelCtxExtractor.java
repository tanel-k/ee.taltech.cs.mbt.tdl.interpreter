package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.labels;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.template.SelectionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.template.SynchronizationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.gui.GuiCoordinatesCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;

import java.util.Collection;
import java.util.Set;

public class LabelCtxExtractor implements IPicklerContextExtractor<AbsUtaLabel<?>>, ILabelVisitor<ContextBuilder> {
	public static LabelCtxExtractor getInstance() {
		return new LabelCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private LabelCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsUtaLabel<?> label) {
		return label.accept(this);
	}

	@Override
	public ContextBuilder visitAssignments(AssignmentsLabel label) {
		CollectionUtils.addAll(requiredClasses, label.getClass(), AbsExpression.class);
		ContextBuilder coordinatesCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(label.getCoordinates(), requiredClasses);
		Collection<ContextBuilder> expressionCtxs = ExpressionCtxExtractor.getInstance()
				.extract(label.getContent(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("coordinates", coordinatesCtx)
				.put("expressions", expressionCtxs);
	}

	@Override
	public ContextBuilder visitComment(CommentLabel label) {
		requiredClasses.add(label.getClass());
		ContextBuilder coordinatesCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(label.getCoordinates(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("coordinates", coordinatesCtx)
				.put("text", label.getContent());
	}

	@Override
	public ContextBuilder visitGuard(GuardLabel label) {
		requiredClasses.add(label.getClass());

		ContextBuilder coordinatesCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(label.getCoordinates(), requiredClasses);
		ContextBuilder exprCtx = ExpressionCtxExtractor.getInstance()
				.extract(label.getContent(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("coordinates", coordinatesCtx)
				.put("expression", exprCtx);
	}

	@Override
	public ContextBuilder visitInvariant(InvariantLabel label) {
		requiredClasses.add(label.getClass());
		ContextBuilder coordinatesCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(label.getCoordinates(), requiredClasses);
		ContextBuilder exprCtx = ExpressionCtxExtractor.getInstance()
				.extract(label.getContent(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("coordinates", coordinatesCtx)
				.put("expression", exprCtx);
	}

	@Override
	public ContextBuilder visitSelection(SelectionLabel label) {
		requiredClasses.add(label.getClass());
		ContextBuilder coordinatesCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(label.getCoordinates(), requiredClasses);
		Collection<ContextBuilder> selectionCtxs = SelectionCtxExtractor.getInstance()
				.extract(label.getContent(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("coordinates", coordinatesCtx)
				.put("selections", selectionCtxs);
	}

	@Override
	public ContextBuilder visitSynchronization(SynchronizationLabel label) {
		requiredClasses.add(label.getClass());
		ContextBuilder coordinatesCtx = GuiCoordinatesCtxExtractor.getInstance()
				.extract(label.getCoordinates(), requiredClasses);
		ContextBuilder synchronizationCtx = SynchronizationCtxExtractor.getInstance()
				.extract(label.getContent(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("coordinates", coordinatesCtx)
				.put("synchronization", synchronizationCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
