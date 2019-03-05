package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical.AbsBinaryLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class ConjunctionNode extends AbsBinaryLogicalOperatorNode<AbsLogicalOperatorNode> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitConjunctionNode(this);
	}
}

