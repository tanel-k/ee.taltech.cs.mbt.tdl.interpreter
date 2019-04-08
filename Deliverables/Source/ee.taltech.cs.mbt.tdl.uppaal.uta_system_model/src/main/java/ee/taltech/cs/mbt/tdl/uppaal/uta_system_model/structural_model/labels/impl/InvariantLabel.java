package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;

public class InvariantLabel extends AbsUtaLabel<AbsExpression> {
	public static InvariantLabel of(AbsExpression expression) {
		InvariantLabel inst = new InvariantLabel();
		inst.setContent(expression);
		return inst;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitInvariant(this);
	}
}
