package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;

import java.util.Collection;
import java.util.LinkedList;

public class TransitionLabels implements IDeepCloneable<TransitionLabels> {
	private CommentLabel commentLabel;
	private GuardLabel guardLabel;
	private AssignmentsLabel assignmentsLabel;
	private SelectionLabel selectLabel;
	private SynchronizationLabel synchronizationLabel;

	public GuardLabel getGuardLabel() {
		return guardLabel;
	}

	public TransitionLabels setGuardLabel(GuardLabel guardLabel) {
		this.guardLabel = guardLabel;
		return this;
	}

	public AssignmentsLabel getAssignmentsLabel() {
		return assignmentsLabel;
	}

	public TransitionLabels setAssignmentsLabel(AssignmentsLabel assignmentsLabel) {
		this.assignmentsLabel = assignmentsLabel;
		return this;
	}

	public SelectionLabel getSelectionLabel() {
		return selectLabel;
	}

	public TransitionLabels setSelectionLabel(SelectionLabel selectLabel) {
		this.selectLabel = selectLabel;
		return this;
	}

	public SynchronizationLabel getSynchronizationLabel() {
		return synchronizationLabel;
	}

	public TransitionLabels setSynchronizationLabel(SynchronizationLabel synchronizationLabel) {
		this.synchronizationLabel = synchronizationLabel;
		return this;
	}

	public CommentLabel getCommentLabel() {
		return commentLabel;
	}

	public TransitionLabels setCommentLabel(CommentLabel commentLabel) {
		this.commentLabel = commentLabel;
		return this;
	}

	public Collection<AbsUtaLabel<?>> asCollection() {
		return CollectionUtils.collectionBuilder(new LinkedList<AbsUtaLabel<?>>())
				.addIfNonNull(commentLabel)
				.addIfNonNull(guardLabel)
				.addIfNonNull(assignmentsLabel)
				.addIfNonNull(selectLabel)
				.addIfNonNull(synchronizationLabel)
				.build();
	}

	@Override
	public TransitionLabels deepClone() {
		TransitionLabels clone = new TransitionLabels();
		clone.commentLabel = commentLabel != null
				? commentLabel.deepClone()
				: null;
		clone.assignmentsLabel = assignmentsLabel != null
				? assignmentsLabel.deepClone()
				: null;
		clone.guardLabel = guardLabel != null
				? guardLabel.deepClone()
				: null;
		clone.selectLabel = selectLabel != null
				? selectLabel.deepClone()
				: null;
		clone.synchronizationLabel = synchronizationLabel != null
				? synchronizationLabel.deepClone()
				: null;
		return clone;
	}
}
