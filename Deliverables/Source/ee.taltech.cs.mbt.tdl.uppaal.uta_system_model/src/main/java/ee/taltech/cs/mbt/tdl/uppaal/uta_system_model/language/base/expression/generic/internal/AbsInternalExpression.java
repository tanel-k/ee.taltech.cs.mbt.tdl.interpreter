package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public abstract class AbsInternalExpression extends AbsExpression {
	public AbsInternalExpression(int childCount) {
		super(childCount);
	}

	public AbsInternalExpression(String id, int childCount) {
		super(id, childCount);
	}
}
