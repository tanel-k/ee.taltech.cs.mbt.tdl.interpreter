package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;

public class NegatedExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
