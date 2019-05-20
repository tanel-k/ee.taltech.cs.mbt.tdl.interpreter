package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic;

/**
 * Represents the class of expressions which can only occur as leaves (or the root).<br/>
 * Meant to be extended by classes which represent literals.
 */
public abstract class AbsLeafExprNode extends AbsExpression {
	private static final int CHILD_COUNT = 0;

	protected AbsLeafExprNode() { super(CHILD_COUNT); }
}
