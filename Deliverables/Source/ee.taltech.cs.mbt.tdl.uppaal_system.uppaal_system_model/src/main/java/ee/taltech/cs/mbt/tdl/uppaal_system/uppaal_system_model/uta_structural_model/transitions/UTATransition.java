package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.locations.UTALocation;

public class UTATransition {
	private UTALocation sourceLocation;
	private UTALocation targetLocation;

	private UTATransitionLabelContainer labelContainer;

	public UTALocation getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(UTALocation sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public UTALocation getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(UTALocation targetLocation) {
		this.targetLocation = targetLocation;
	}
}
