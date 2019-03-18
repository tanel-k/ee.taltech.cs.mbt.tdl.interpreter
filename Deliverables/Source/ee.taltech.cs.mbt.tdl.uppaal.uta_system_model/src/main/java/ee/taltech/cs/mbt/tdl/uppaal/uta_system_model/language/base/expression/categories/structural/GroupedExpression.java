package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.structural;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;

public class GroupedExpression extends AbsUnaryExpression {
	public GroupedExpression() { }

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
