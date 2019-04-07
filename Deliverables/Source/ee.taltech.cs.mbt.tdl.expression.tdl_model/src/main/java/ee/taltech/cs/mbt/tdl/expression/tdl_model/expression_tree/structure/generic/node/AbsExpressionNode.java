package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpressionVisitor;

public abstract class AbsExpressionNode {
	private AbsExpressionNode parentNode;

	public AbsExpressionNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(AbsExpressionNode parentNode) {
		this.parentNode = parentNode;
	}

	public abstract <T> T accept(TdlExpressionVisitor<T> visitor);
}
