package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

public class UtaGuardLabel extends AbsUtaLabel<AbsExpression> {
	public static UtaGuardLabel of(AbsExpression expression) {
		UtaGuardLabel inst = new UtaGuardLabel();
		inst.setContent(expression);
		return inst;
	}
}
