package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node.pseudo_leaf.BoundNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class LeadsToBoundedNode extends LeadsToNode implements IBounded {
	private BoundNode boundNode;

	@Override
	public BoundNode getBoundNode() {
		return boundNode;
	}

	@Override
	public void setBoundNode(BoundNode boundNode) {
		this.boundNode = boundNode;
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitLeadsToBoundedNode(this);
	}
}
