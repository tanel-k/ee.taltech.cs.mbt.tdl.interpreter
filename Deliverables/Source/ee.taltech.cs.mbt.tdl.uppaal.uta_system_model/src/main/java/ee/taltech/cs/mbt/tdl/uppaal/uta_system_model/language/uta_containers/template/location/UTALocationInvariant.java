package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.template.location;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTALocationInvariant {
	private AbsExpression invariantExpression;

	public AbsExpression getInvariantExpression() {
		return invariantExpression;
	}

	public void setInvariantExpression(AbsExpression invariantExpression) {
		this.invariantExpression = invariantExpression;
	}
}
