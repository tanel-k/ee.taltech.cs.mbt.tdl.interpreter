package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

/**
 * Represents the class of expressions which have three child expressions.<br/>
 * Convenience class.
 */
public abstract class AbsTernaryExpression extends AbsInternalExpression {
	public static final int CHILD_COUNT = 3;

	private static final int POSITION_LEFT = 0;
	private static final int POSITION_MIDDLE = 1;
	private static final int POSITION_RIGHT = 2;

	public AbsTernaryExpression() { super(CHILD_COUNT); }
	public AbsTernaryExpression(String id) {
		super(id, CHILD_COUNT);
	}

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
}
