package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

public abstract class AbsExpressionLeafNode<RepresentationType> extends AbsExpressionNode {
	private RepresentationType symbol;

	protected AbsExpressionLeafNode(RepresentationType symbol) {
		this.symbol = symbol;
	}

	public RepresentationType getRepresentation() {
		return symbol;
	}

	public void setRepresentation(RepresentationType symbol) {
		this.symbol = symbol;
	}

	@Override
	public abstract AbsExpressionLeafNode<RepresentationType> deepClone();
}
