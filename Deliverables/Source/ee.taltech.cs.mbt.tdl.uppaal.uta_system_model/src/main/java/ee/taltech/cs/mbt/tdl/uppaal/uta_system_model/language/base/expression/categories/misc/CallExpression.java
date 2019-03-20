package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

import java.util.Iterator;
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
public class CallExpression extends AbsUnaryExpression {
	private List<AbsExpression> argumentList = new LinkedList<>();

	/**
	 * @return Arguments supplied in the call.
	 */
	public List<AbsExpression> getArgumentList() {
		return argumentList;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitCall(this);
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getArgumentList());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof CallExpression))
				return false;
			CallExpression other = (CallExpression) obj;
			return Objects.equals(other.argumentList, this.argumentList);
		}
		return false;
	}
}
