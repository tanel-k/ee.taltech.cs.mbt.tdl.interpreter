package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels.*;
import ee.taltech.cs.mbt.tdl.uppaal_system.uta_system_model.uta_structural_model.labels.*;

public class UTATransitionLabelContainer {
	private UTAGuardLabel guardLabel;
	private UTAAssignmentsLabel assignmentsLabel;
	private UTASelectLabel selectLabel;
	private UTASynchronizationLabel synchronizationLabel;

	private UTACommentLabel commentLabel;

	public UTAGuardLabel getGuardLabel() {
		return guardLabel;
	}

	public void setGuardLabel(UTAGuardLabel guardLabel) {
		this.guardLabel = guardLabel;
	}

	public UTAAssignmentsLabel getAssignmentsLabel() {
		return assignmentsLabel;
	}

	public void setAssignmentsLabel(UTAAssignmentsLabel assignmentsLabel) {
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
