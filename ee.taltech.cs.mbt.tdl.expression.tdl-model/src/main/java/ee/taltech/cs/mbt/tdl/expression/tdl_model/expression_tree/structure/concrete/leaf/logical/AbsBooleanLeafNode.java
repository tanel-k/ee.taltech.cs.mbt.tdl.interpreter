package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsLeafNode;

public abstract class AbsBooleanLeafNode extends AbsLeafNode {
	@Override
	public abstract AbsBooleanLeafNode deepClone();
}
