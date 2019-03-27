package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.structural;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

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
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitGroup(this);
	}
}
