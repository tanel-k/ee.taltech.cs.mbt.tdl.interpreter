package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

/**
 * Represents the class of expressions which have one child expressions.<br/>
 * Convenience class.
 */
public abstract class AbsUnaryExpression extends AbsInternalExpression {
	public static final int CHILD_COUNT = 1;

	private static final int POSITION = 0;

	public AbsUnaryExpression() { super(CHILD_COUNT); }

	public AbsUnaryExpression(String id) {
		super(id, CHILD_COUNT);
	}

	public AbsExpression getChild() {
		return getChildExpression(POSITION);
	}

	public void setChild(AbsExpression operand) {
		setChildExpression(POSITION, operand);
	}
}
