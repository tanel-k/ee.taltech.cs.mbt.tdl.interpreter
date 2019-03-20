package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.leaf;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

/**
 * Represents the class of expressions which can only occur as leaves (or the root).<br/>
 * Meant to be extended by classes which represent literals.
 */
public abstract class AbsLeafExpression extends AbsExpression {
	private static final int CHILD_COUNT = 0;

	protected AbsLeafExpression() { super(CHILD_COUNT); }
}
