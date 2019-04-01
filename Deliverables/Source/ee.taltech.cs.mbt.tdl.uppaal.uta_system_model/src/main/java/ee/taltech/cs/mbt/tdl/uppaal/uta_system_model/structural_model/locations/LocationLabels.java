package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.InvariantLabel;

public class LocationLabels {
	private InvariantLabel invariantLabel;
	private CommentLabel commentLabel;

	public InvariantLabel getInvariantLabel() {
		return invariantLabel;
	}

	public void setInvariantLabel(InvariantLabel invariantLabel) {
		this.invariantLabel = invariantLabel;
	}

	public CommentLabel getCommentLabel() {
		return commentLabel;
	}

	public void setCommentLabel(CommentLabel commentLabel) {
		this.commentLabel = commentLabel;
	}
}
