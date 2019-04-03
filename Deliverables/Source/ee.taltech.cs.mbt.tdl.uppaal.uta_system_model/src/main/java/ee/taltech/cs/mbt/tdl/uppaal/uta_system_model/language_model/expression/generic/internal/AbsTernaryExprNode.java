package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsInternalExprNode;

/**
 * Represents the class of expressions which have three child expressions.<br/>
 * Convenience class.
 */
public abstract class AbsTernaryExprNode extends AbsInternalExprNode {
	public static final int CHILD_COUNT = 3;

	private static final int POSITION_LEFT = 0;
	private static final int POSITION_MIDDLE = 1;
	private static final int POSITION_RIGHT = 2;

	public AbsTernaryExprNode() { super(CHILD_COUNT); }

	public AbsExpression getLeftChild() {
		return getChildExpression(POSITION_LEFT);
	}

	public void setLeftChild(AbsExpression expression) {
		setChildExpression(POSITION_LEFT, expression);
	}

	public AbsExpression getMiddleChild() {
		return getChildExpression(POSITION_LEFT);
	}

	public void setMiddleChild(AbsExpression expression) {
		setChildExpression(POSITION_MIDDLE, expression);
	}

	public AbsExpression getRightChild() {
		return getChildExpression(POSITION_RIGHT);
	}

	public void setRightChild(AbsExpression expression) {
		setChildExpression(POSITION_RIGHT, expression);
	}

	protected abstract AbsTernaryExprNode topLevelClone();

	@Override
	public AbsExpression deepClone() {
		AbsTernaryExprNode clone = topLevelClone();
		clone.setLeftChild(getLeftChild().deepClone());
		clone.setMiddleChild(getMiddleChild().deepClone());
		clone.setRightChild(getRightChild().deepClone());
		return clone;
	}
}
