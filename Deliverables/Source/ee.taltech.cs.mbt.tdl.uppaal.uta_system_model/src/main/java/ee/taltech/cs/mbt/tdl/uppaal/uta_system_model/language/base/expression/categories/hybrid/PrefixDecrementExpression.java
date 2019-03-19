package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.hybrid;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

public class PrefixDecrementExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitPrefixDecrement(this);
	}
}