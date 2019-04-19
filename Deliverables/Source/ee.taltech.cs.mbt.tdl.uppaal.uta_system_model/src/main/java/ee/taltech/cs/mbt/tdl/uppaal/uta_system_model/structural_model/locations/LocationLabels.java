package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.InvariantLabel;

import java.util.Collection;
import java.util.LinkedList;

public class LocationLabels implements IDeepCloneable<LocationLabels> {
	private InvariantLabel invariantLabel;
	private CommentLabel commentLabel;

	public InvariantLabel getInvariantLabel() {
		return invariantLabel;
	}

	public LocationLabels setInvariantLabel(InvariantLabel invariantLabel) {
		this.invariantLabel = invariantLabel;
		return this;
	}

	public CommentLabel getCommentLabel() {
		return commentLabel;
	}

	public LocationLabels setCommentLabel(CommentLabel commentLabel) {
		this.commentLabel = commentLabel;
		return this;
	}

	public Collection<AbsUtaLabel<?>> asCollection() {
		return CollectionUtils.collectionBuilder(new LinkedList<AbsUtaLabel<?>>())
				.addIfNonNull(invariantLabel)
				.addIfNonNull(commentLabel)
				.build();
	}

	public LocationLabels deepClone() {
		LocationLabels clone = new LocationLabels();
		clone.invariantLabel = invariantLabel != null
				? invariantLabel.deepClone()
				: null;
		clone.commentLabel = commentLabel != null
				? commentLabel.deepClone()
				: null;
		return clone;
	}
}
