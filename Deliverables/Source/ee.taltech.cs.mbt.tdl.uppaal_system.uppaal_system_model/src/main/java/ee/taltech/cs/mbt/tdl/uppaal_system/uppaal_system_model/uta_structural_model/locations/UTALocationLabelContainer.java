package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.locations;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.labels.UTACommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.labels.UTAInvariantLabel;

public class UTALocationLabelContainer {
	private UTAInvariantLabel invariantLabel;
	private UTACommentLabel commentLabel;

	public UTAInvariantLabel getInvariantLabel() {
		return invariantLabel;
	}

	public void setInvariantLabel(UTAInvariantLabel invariantLabel) {
		this.invariantLabel = invariantLabel;
	}

	public UTACommentLabel getCommentLabel() {
		return commentLabel;
	}

	public void setCommentLabel(UTACommentLabel commentLabel) {
		this.commentLabel = commentLabel;
	}
}
