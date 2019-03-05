package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.logical.AbsBinaryLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.logical.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class ConjunctionNode extends AbsBinaryLogicalOperatorNode<AbsLogicalOperatorNode> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitConjunctionNode(this);
	}
}

