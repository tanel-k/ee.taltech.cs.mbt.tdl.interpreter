package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents a division operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '/' Expression
 *             | ...
 * </pre>
 * <br/>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getLeftChild()}</td>
 *     <td>The left operand.</td>
 *   </tr>
 *   <tr>
 *     <td>{@link #getRightChild()}</td>
 *     <td>The right operand.</td>
 *   </tr>
 * </table>
 */
public class DivisionExpression extends AbsBinaryExprNode implements IHasAssignmentCounterpart {
	private boolean assignment;

	@Override
	public boolean isAssignment() {
		return assignment;
	}

	@Override
	public DivisionExpression setAssignment(boolean assignment) {
		this.assignment = assignment;
		return this;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitDivisionExpr(this);
	}

	@Override
	protected DivisionExpression topLevelClone() {
		DivisionExpression clone = new DivisionExpression();
		clone.setAssignment(isAssignment());
		return clone;
	}

	@Override
	public DivisionExpression deepClone() {
		return (DivisionExpression) super.deepClone();
	}
}
