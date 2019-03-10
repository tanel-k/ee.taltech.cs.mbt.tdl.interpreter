package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node;

public abstract class AbsExpressionNode {
	private AbsExpressionNode parentNode;

	public AbsExpressionNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(AbsExpressionNode parentNode) {
		this.parentNode = parentNode;
	}
}
