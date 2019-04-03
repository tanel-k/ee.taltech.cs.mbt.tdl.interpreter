package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.InvariantLabel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

	public Collection<AbsUtaLabel<?>> asCollection() {
		List<AbsUtaLabel<?>> labels = new LinkedList<>();
		CollectionUtils.addIfNonNull(labels, invariantLabel);
		CollectionUtils.addIfNonNull(labels, commentLabel);
		return labels;
	}
}
