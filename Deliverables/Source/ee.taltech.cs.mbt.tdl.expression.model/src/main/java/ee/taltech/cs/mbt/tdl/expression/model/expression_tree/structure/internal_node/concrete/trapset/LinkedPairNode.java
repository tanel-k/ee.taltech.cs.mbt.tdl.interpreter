package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.trapset.AbsBinaryTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class LinkedPairNode extends AbsBinaryTrapsetOperatorNode {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitLinkedPairNode(this);
	}
}

