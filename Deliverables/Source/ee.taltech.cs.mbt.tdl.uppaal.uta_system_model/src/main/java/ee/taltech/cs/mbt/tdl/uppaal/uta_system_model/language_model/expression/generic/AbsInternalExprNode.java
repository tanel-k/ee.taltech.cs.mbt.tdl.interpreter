package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic;

/**
 * Represents the class of expressions which cannot be leaves in an expression tree.<br/>
 * Marker class.
 */
public abstract class AbsInternalExprNode extends AbsExpression {
	public AbsInternalExprNode(int childCount) {
		super(childCount);
	}
}
