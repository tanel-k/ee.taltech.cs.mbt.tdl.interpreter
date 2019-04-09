package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

public class Synchronization {
	private boolean active;
	private AbsExpression expression;

	public boolean isActiveSync() {
		return active;
	}

	public Synchronization setActiveSync(boolean active) {
		this.active = active;
		return this;
	}

	public AbsExpression getExpression() {
		return expression;
	}

	public Synchronization setExpression(AbsExpression expression) {
		this.expression = expression;
		return this;
	}
}
