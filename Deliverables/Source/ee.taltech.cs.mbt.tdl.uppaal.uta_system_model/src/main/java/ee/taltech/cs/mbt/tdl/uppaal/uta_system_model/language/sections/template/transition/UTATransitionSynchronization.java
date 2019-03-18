package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.template.transition;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTATransitionSynchronization {
	private boolean active;
	private AbsExpression variableExpression;

	public boolean isActiveSync() {
		return active;
	}

	public void setActiveSync(boolean active) {
		this.active = active;
	}

	public AbsExpression getVariableExpression() {
		return variableExpression;
	}

	public void setVariableExpression(AbsExpression variableExpression) {
		this.variableExpression = variableExpression;
	}
}
