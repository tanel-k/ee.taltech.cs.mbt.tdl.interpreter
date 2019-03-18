package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.template.transition;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTATransitionGuard {
	private AbsExpression guardExpression;

	public AbsExpression getGuardExpression() {
		return guardExpression;
	}

	public void setGuardExpression(AbsExpression guardExpression) {
		this.guardExpression = guardExpression;
	}
}
