package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

public class UtaInvariantLabel extends AbsUtaLabel<AbsExpression> {
	public static UtaInvariantLabel of(AbsExpression expression) {
		UtaInvariantLabel inst = new UtaInvariantLabel();
		inst.setContent(expression);
		return inst;
	}
}
