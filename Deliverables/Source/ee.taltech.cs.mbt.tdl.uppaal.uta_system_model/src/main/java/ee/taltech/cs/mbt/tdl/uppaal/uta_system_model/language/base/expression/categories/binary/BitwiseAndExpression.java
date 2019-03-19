package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.binary;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

public class BitwiseAndExpression extends AbsBinaryExpression implements IHasAssignmentCounterpart {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitBitwiseAnd(this);
	}
}
