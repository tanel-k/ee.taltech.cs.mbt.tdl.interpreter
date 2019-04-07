package ee.taltech.cs.mbt.tdl.scenario.scenario_model;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

public class TrapsetMapping<U extends AbsExpression> {
	private Transition transition;
	private U updateFunction;

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	public U getUpdateFunction() {
		return updateFunction;
	}

	public void setUpdateFunction(U updateFunction) {
		this.updateFunction = updateFunction;
	}
}