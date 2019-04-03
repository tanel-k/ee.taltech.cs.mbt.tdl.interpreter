package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.SynchronizationLabel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TransitionLabels {
	private CommentLabel commentLabel;
	private GuardLabel guardLabel;
	private AssignmentsLabel assignmentsLabel;
	private SelectionLabel selectLabel;
	private SynchronizationLabel synchronizationLabel;

	public GuardLabel getGuardLabel() {
		return guardLabel;
	}

	public void setGuardLabel(GuardLabel guardLabel) {
		this.guardLabel = guardLabel;
	}

	public AssignmentsLabel getAssignmentsLabel() {
		return assignmentsLabel;
	}

	public void setAssignmentsLabel(AssignmentsLabel assignmentsLabel) {
		this.assignmentsLabel = assignmentsLabel;
	}

	public SelectionLabel getSelectLabel() {
		return selectLabel;
	}

	public void setSelectLabel(SelectionLabel selectLabel) {
		this.selectLabel = selectLabel;
	}

	public SynchronizationLabel getSynchronizationLabel() {
		return synchronizationLabel;
	}

	public void setSynchronizationLabel(SynchronizationLabel synchronizationLabel) {
		this.synchronizationLabel = synchronizationLabel;
	}

	public CommentLabel getCommentLabel() {
		return commentLabel;
	}

	public void setCommentLabel(CommentLabel commentLabel) {
		this.commentLabel = commentLabel;
	}

	public Collection<AbsUtaLabel<?>> asCollection() {
		List<AbsUtaLabel<?>> labels = new LinkedList<>();
		CollectionUtils.addIfNonNull(labels, commentLabel);
		CollectionUtils.addIfNonNull(labels, guardLabel);
		CollectionUtils.addIfNonNull(labels, assignmentsLabel);
		CollectionUtils.addIfNonNull(labels, selectLabel);
		CollectionUtils.addIfNonNull(labels, synchronizationLabel);
		return labels;
	}
}
