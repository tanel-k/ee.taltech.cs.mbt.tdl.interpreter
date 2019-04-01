package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.*;

public class UtaTransitionLabels {
	private UtaCommentLabel commentLabel;
	private UtaGuardLabel guardLabel;
	private UtaAssignmentsLabel assignmentsLabel;
	private UtaSelectionLabel selectLabel;
	private UtaSynchronizationLabel synchronizationLabel;

	public UtaGuardLabel getGuardLabel() {
		return guardLabel;
	}

	public void setGuardLabel(UtaGuardLabel guardLabel) {
		this.guardLabel = guardLabel;
	}

	public UtaAssignmentsLabel getAssignmentsLabel() {
		return assignmentsLabel;
	}

	public void setAssignmentsLabel(UtaAssignmentsLabel assignmentsLabel) {
		this.assignmentsLabel = assignmentsLabel;
	}

	public UtaSelectionLabel getSelectLabel() {
		return selectLabel;
	}

	public void setSelectLabel(UtaSelectionLabel selectLabel) {
		this.selectLabel = selectLabel;
	}

	public UtaSynchronizationLabel getSynchronizationLabel() {
		return synchronizationLabel;
	}

	public void setSynchronizationLabel(UtaSynchronizationLabel synchronizationLabel) {
		this.synchronizationLabel = synchronizationLabel;
	}

	public UtaCommentLabel getCommentLabel() {
		return commentLabel;
	}

	public void setCommentLabel(UtaCommentLabel commentLabel) {
		this.commentLabel = commentLabel;
	}
}
