package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.Objects;

public abstract class AbsExpressionLeafNode<RepresentationType> extends AbsExpressionNode {
	private RepresentationType representation;

	protected AbsExpressionLeafNode(RepresentationType representation) {
		this.representation = representation;
	}

	public RepresentationType getRepresentation() {
		return representation;
	}

	public void setRepresentation(RepresentationType symbol) {
		this.representation = symbol;
	}

	@Override
	public abstract AbsExpressionLeafNode<RepresentationType> deepClone();

	@Override
	public int hashCode() {
		return Objects.hash(getRepresentation());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof AbsExpressionLeafNode))
			return false;
		AbsExpressionLeafNode other = (AbsExpressionLeafNode) obj;
		return Objects.equals(other.representation, this.representation);
	}
}
