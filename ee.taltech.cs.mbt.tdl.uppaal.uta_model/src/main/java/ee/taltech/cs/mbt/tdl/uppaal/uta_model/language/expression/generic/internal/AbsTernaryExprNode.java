package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsInternalExprNode;

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

	public AbsTernaryExprNode setLeftChild(AbsExpression expression) {
		setChildExpression(POSITION_LEFT, expression);
		return this;
	}

	public AbsExpression getMiddleChild() {
		return getChildExpression(POSITION_MIDDLE);
	}

	public AbsTernaryExprNode setMiddleChild(AbsExpression expression) {
		setChildExpression(POSITION_MIDDLE, expression);
		return this;
	}

	public AbsExpression getRightChild() {
		return getChildExpression(POSITION_RIGHT);
	}

	public AbsTernaryExprNode setRightChild(AbsExpression expression) {
		setChildExpression(POSITION_RIGHT, expression);
		return this;
	}

	protected abstract AbsTernaryExprNode topLevelClone();

	@Override
	public AbsExpression deepClone() {
		return topLevelClone()
				.setLeftChild(getLeftChild().deepClone())
				.setMiddleChild(getMiddleChild().deepClone())
				.setRightChild(getRightChild().deepClone());
	}
}
