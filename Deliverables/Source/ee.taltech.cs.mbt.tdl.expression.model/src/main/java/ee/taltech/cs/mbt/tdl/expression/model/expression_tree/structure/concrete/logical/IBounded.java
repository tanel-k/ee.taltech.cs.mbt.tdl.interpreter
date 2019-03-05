package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.modifier.BoundNode;

public interface IBounded {
	BoundNode getBoundNode();
	void setBoundNode(BoundNode boundNode);
}
