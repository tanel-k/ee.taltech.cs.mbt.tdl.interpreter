package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

public class GuardLabel extends AbsUtaLabel<AbsExpression> {
	public static GuardLabel of(AbsExpression expression) {
		GuardLabel inst = new GuardLabel();
		inst.setContent(expression);
		return inst;
	}
}
