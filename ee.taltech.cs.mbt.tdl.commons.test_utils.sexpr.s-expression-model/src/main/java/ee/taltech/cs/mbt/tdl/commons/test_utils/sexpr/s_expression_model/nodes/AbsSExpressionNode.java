package ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.nodes;

public abstract class AbsSExpressionNode {
	private SExpressionSequenceNode parent;

	public SExpressionSequenceNode getParent() {
		return parent;
	}

	public AbsSExpressionNode setParent(SExpressionSequenceNode parent) {
		this.parent = parent;
		return this;
	}

	public abstract <T> T accept(ISExpressionVisitor<T> visitor);

	@Override
	public abstract boolean equals(Object obj);
}
