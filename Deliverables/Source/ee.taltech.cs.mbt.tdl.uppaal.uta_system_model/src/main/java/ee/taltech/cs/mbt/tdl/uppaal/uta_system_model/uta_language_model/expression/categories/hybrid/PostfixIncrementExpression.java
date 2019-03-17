package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.categories.hybrid;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.internal.AbsUnaryExpression;

public class PostfixIncrementExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}
}
