package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsInternalExprNode;

/**
 * Represents the class of expressions which have one child expressions.<br/>
 * Convenience class.
 */
public abstract class AbsUnaryExprNode extends AbsInternalExprNode {
	public static final int CHILD_COUNT = 1;

	private static final int POSITION = 0;

	public AbsUnaryExprNode() { super(CHILD_COUNT); }

	public AbsExpression getChild() {
		return getChildExpression(POSITION);
	}

	public void setChild(AbsExpression operand) {
		setChildExpression(POSITION, operand);
	}
}
