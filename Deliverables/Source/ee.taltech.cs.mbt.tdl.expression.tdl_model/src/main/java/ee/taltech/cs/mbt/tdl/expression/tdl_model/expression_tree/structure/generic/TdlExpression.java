package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;

public class TdlExpression {
	private AbsLogicalOperatorNode rootNode;

	public AbsLogicalOperatorNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(AbsLogicalOperatorNode rootNode) {
		this.rootNode = rootNode;
	}
}
