package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.*;

public class UTATransitionLabelContainer {
	private UTAGuardLabel guardLabel;
	private UTAUpdatesLabel assignmentsLabel;
	private UTASelectLabel selectLabel;
	private UTASynchronizationLabel synchronizationLabel;

	private UTACommentLabel commentLabel;

	public UTAGuardLabel getGuardLabel() {
		return guardLabel;
	}

	public void setGuardLabel(UTAGuardLabel guardLabel) {
		this.guardLabel = guardLabel;
	}

	public UTAUpdatesLabel getAssignmentsLabel() {
		return assignmentsLabel;
	}

	public void setAssignmentsLabel(UTAUpdatesLabel assignmentsLabel) {
		this.assignmentsLabel = assignmentsLabel;
	}

	public UTASelectLabel getSelectLabel() {
		return selectLabel;
	}

	public void setSelectLabel(UTASelectLabel selectLabel) {
		this.selectLabel = selectLabel;
	}

	public UTASynchronizationLabel getSynchronizationLabel() {
		return synchronizationLabel;
	}

	public void setSynchronizationLabel(UTASynchronizationLabel synchronizationLabel) {
		this.synchronizationLabel = synchronizationLabel;
	}
}
