package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical.AbsUnaryLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.trapset.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class UniversalQuantificationNode extends AbsUnaryLogicalOperatorNode<AbsTrapsetOperatorNode> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitUniversalQuantificationNode(this);
	}
}
