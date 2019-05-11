package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

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
public class GroupedExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitGroupExpr(this);
	}

	@Override
	protected GroupedExpression topLevelClone() {
		return new GroupedExpression();
	}

	@Override
	public GroupedExpression deepClone() {
		return (GroupedExpression) super.deepClone();
	}
}
