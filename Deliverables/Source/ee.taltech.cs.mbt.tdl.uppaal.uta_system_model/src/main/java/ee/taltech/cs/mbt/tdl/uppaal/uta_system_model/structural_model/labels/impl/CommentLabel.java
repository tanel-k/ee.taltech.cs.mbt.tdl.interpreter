package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;

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
}
