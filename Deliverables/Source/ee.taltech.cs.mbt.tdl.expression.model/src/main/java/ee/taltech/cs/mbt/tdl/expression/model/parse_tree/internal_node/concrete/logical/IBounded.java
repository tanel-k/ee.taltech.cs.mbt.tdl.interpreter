package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.bound.BoundNode;

public interface IBounded {
	public BoundNode getBoundNode();
	public void setBoundNode(BoundNode boundNode);
}
