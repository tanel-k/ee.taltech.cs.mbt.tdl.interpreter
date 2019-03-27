package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.UtaCommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.UtaInvariantLabel;

public class UtaLocationLabels {
	private UtaInvariantLabel invariantLabel;
	private UtaCommentLabel commentLabel;

	public UtaInvariantLabel getInvariantLabel() {
		return invariantLabel;
	}

	public void setInvariantLabel(UtaInvariantLabel invariantLabel) {
		this.invariantLabel = invariantLabel;
	}

	public UtaCommentLabel getCommentLabel() {
		return commentLabel;
	}

	public void setCommentLabel(UtaCommentLabel commentLabel) {
		this.commentLabel = commentLabel;
	}
}
