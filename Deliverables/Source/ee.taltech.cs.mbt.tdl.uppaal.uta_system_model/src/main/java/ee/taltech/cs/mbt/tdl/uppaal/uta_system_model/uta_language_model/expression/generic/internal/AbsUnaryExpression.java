package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.AbsExpression;

public abstract class AbsUnaryExpression extends AbsInternalExpression {
	public static final int CHILD_COUNT = 1;

	private static final int POSITION = 0;

	public AbsUnaryExpression() { super(CHILD_COUNT); }

	public AbsUnaryExpression(String id) {
		super(id, CHILD_COUNT);
	}

	public AbsExpression getExpression() {
		return getChildExpression(POSITION);
	}

	public void setExpression(AbsExpression operand) {
		setChildExpression(POSITION, operand);
	}
}
