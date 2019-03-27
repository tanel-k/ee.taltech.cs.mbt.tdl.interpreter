package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;

/**
 * Represents the class of expressions which have two child expressions.<br/>
 * Convenience class.
 */
public abstract class AbsBinaryExpression extends AbsInternalExpression {
	public static final int CHILD_COUNT = 2;

	private static final int POSITION_LEFT = 0;
	private static final int POSITION_RIGHT = 1;

	public AbsBinaryExpression() { super(CHILD_COUNT); }

	public AbsBinaryExpression(String id) {
		super(id, CHILD_COUNT);
	}

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
}
