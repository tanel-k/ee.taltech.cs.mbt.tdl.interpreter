package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors.structure.labels;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors.structure.gui.GuiCoordinatesCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;

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
		return ContextBuilder.newBuilder("assignmentsLabel");
	}

	@Override
	public ContextBuilder visitComment(CommentLabel label) {
		return ContextBuilder.newBuilder("commentLabel")
				.put("guiCoordinates", GuiCoordinatesCtxExtractor.getInstance().extract(label.getCoordinates()))
				.put("text", label.getContent());
	}

	@Override
	public ContextBuilder visitGuard(GuardLabel label) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitInvariant(InvariantLabel label) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitSelection(SelectionLabel label) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitSynchronization(SynchronizationLabel label) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
