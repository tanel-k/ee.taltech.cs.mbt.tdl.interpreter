package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.*;

public class UtaTransitionLabels {
	private UtaCommentLabel commentLabel;
	private UtaGuardLabel guardLabel;
	private UtaUpdatesLabel assignmentsLabel;
	private UtaSelectLabel selectLabel;
	private UtaSynchronizationLabel synchronizationLabel;

	public UtaGuardLabel getGuardLabel() {
		return guardLabel;
	}

	public void setGuardLabel(UtaGuardLabel guardLabel) {
		this.guardLabel = guardLabel;
	}

	public UtaUpdatesLabel getAssignmentsLabel() {
		return assignmentsLabel;
	}

	public void setAssignmentsLabel(UtaUpdatesLabel assignmentsLabel) {
		this.assignmentsLabel = assignmentsLabel;
	}

	public UtaSelectLabel getSelectLabel() {
		return selectLabel;
	}

	public void setSelectLabel(UtaSelectLabel selectLabel) {
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
