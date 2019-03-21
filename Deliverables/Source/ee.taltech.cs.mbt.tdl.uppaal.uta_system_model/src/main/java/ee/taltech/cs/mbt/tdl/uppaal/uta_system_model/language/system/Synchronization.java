package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class Synchronization {
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