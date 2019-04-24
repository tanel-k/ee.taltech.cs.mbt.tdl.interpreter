package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.ILabelVisitor;

public class CommentLabel extends AbsUtaLabel<String> {
	public static CommentLabel of(String comment) {
		CommentLabel inst = new CommentLabel();
		inst.setContent(comment == null ? "" : comment);
		return inst;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitComment(this);
	}

	@Override
	public CommentLabel deepClone() {
		CommentLabel clone = new CommentLabel();
		clone.setContent(getContent());
		return clone;
	}
}
