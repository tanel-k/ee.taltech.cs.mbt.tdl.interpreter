package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an UPPAAL structured type field access.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '.' ID
 *             | ...
 * </pre>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()}</td>
 *     <td>The expression that gets called.</td>
 *   </tr>
 * </table>
 */
public class CallExpression extends AbsUnaryExprNode {
	private List<AbsExpression> argumentList = new LinkedList<>();

	/**
	 * @return Arguments supplied in the call.
	 */
	public List<AbsExpression> getArgumentList() {
		return argumentList;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitCallExpr(this);
	}
}
