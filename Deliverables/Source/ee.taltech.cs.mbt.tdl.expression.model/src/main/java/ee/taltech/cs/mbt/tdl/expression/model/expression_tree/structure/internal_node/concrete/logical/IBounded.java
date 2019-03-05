package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node.pseudo_leaf.BoundNode;

public interface IBounded {
	BoundNode getBoundNode();
	void setBoundNode(BoundNode boundNode);
}
