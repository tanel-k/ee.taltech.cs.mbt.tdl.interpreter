package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents a modulo operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '%' Expression
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
public class ModuloExpression extends AbsBinaryExprNode implements IHasAssignmentCounterpart {
	private boolean assignment;

	@Override
	public boolean isAssignment() {
		return assignment;
	}

	@Override
	public ModuloExpression setAssignment(boolean assignment) {
		this.assignment = assignment;
		return this;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitModuloExpr(this);
	}

	@Override
	protected ModuloExpression topLevelClone() {
		ModuloExpression clone = new ModuloExpression();
		clone.setAssignment(isAssignment());
		return clone;
	}

	@Override
	public ModuloExpression deepClone() {
		return (ModuloExpression) super.deepClone();
	}
}
