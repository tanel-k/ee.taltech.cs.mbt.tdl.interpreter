package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.structural;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

/**
 * Represents a grouped expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ID
 *             | ...
 *             |  '(' Expression ')'
 *             | ...
 * </pre>
 */
public class GroupedExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitGroup(this);
	}
}
