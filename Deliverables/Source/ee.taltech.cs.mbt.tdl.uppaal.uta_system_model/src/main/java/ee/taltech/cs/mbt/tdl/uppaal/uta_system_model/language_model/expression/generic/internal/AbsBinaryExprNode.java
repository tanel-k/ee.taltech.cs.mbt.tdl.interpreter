package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsInternalExprNode;

/**
 * Represents the class of expressions which have two child expressions.<br/>
 * Convenience class.
 */
public abstract class AbsBinaryExprNode extends AbsInternalExprNode {
	public static final int CHILD_COUNT = 2;

	private static final int POSITION_LEFT = 0;
	private static final int POSITION_RIGHT = 1;

	public AbsBinaryExprNode() { super(CHILD_COUNT); }

	public AbsExpression getLeftChild() {
		return getChildExpression(POSITION_LEFT);
	}

	public void setLeftChild(AbsExpression expression) {
		setChildExpression(POSITION_LEFT, expression);
	}

	public AbsExpression getRightChild() {
		return getChildExpression(POSITION_RIGHT);
	}

	public void setRightChild(AbsExpression expression) {
		setChildExpression(POSITION_RIGHT, expression);
	}

	protected abstract AbsBinaryExprNode topLevelClone();

	@Override
	public AbsExpression deepClone() {
		AbsBinaryExprNode clone = topLevelClone();
		clone.setLeftChild(getLeftChild().deepClone());
		clone.setRightChild(getRightChild().deepClone());
		return clone;
	}
}
