package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes;

public abstract class AbsSExprNode {
	private SExprSequenceNode parent;

	public SExprSequenceNode getParent() {
		return parent;
	}

	public AbsSExprNode setParent(SExprSequenceNode parent) {
		this.parent = parent;
		return this;
	}
}
