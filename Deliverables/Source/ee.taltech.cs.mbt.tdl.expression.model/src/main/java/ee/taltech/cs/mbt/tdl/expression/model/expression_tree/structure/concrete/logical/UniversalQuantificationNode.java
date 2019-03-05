package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.logical.AbsUnaryLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.trapset.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class UniversalQuantificationNode extends AbsUnaryLogicalOperatorNode<AbsTrapsetOperatorNode> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitUniversalQuantificationNode(this);
	}
}
