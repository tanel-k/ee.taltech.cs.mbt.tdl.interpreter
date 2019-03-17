package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.AbsExpression;

public abstract class AbsTernaryExpression extends AbsInternalExpression {
	public static final int CHILD_COUNT = 3;

	private static final int POSITION_LEFT = 0;
	private static final int POSITION_MIDDLE = 1;
	private static final int POSITION_RIGHT = 2;

	public AbsTernaryExpression() { super(CHILD_COUNT); }
	public AbsTernaryExpression(String id) {
		super(id, CHILD_COUNT);
	}

	public AbsExpression getLeftExpression() {
		return getChildExpression(POSITION_LEFT);
	}

	public void setLeftExpression(AbsExpression expression) {
		setChildExpression(POSITION_LEFT, expression);
	}

	public AbsExpression getMiddleExpression() {
		return getChildExpression(POSITION_LEFT);
	}

	public void setMiddleExpression(AbsExpression expression) {
		setChildExpression(POSITION_MIDDLE, expression);
	}

	public AbsExpression getRightExpression() {
		return getChildExpression(POSITION_RIGHT);
	}

	public void setRightExpression(AbsExpression expression) {
		setChildExpression(POSITION_RIGHT, expression);
	}
}
