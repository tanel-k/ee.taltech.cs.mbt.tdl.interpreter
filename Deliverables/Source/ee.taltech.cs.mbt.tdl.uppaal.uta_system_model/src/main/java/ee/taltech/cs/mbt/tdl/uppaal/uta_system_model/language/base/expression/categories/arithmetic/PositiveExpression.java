package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.arithmetic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;

public class PositiveExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}
}
