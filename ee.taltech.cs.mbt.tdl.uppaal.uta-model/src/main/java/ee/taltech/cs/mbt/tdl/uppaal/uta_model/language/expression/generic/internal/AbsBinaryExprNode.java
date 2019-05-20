package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsInternalExprNode;

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

	public AbsBinaryExprNode setLeftChild(AbsExpression expression) {
		setChildExpression(POSITION_LEFT, expression);
		return this;
	}

	public AbsExpression getRightChild() {
		return getChildExpression(POSITION_RIGHT);
	}

	public AbsBinaryExprNode setRightChild(AbsExpression expression) {
		setChildExpression(POSITION_RIGHT, expression);
		return this;
	}

	protected abstract AbsBinaryExprNode topLevelClone();

	@Override
	public AbsExpression deepClone() {
		return topLevelClone()
				.setLeftChild(getLeftChild().deepClone())
				.setRightChild(getRightChild().deepClone());
	}
}
