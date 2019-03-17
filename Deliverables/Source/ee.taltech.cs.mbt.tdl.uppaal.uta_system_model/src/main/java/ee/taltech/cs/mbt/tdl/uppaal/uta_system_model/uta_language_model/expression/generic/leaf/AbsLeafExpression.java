package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.leaf;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.AbsExpression;

public class AbsLeafExpression extends AbsExpression {
	private static final int CHILD_COUNT = 0;

	public AbsLeafExpression() { super(CHILD_COUNT); }

	public AbsLeafExpression(String id) {
		super(id, CHILD_COUNT);
	}
}
