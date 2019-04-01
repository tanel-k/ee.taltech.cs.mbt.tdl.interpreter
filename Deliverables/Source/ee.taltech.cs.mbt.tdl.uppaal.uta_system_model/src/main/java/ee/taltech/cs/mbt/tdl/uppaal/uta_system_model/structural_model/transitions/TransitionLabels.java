package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.*;

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
}
