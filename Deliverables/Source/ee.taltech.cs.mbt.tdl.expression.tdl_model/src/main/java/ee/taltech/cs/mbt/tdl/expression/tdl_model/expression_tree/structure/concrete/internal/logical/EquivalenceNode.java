package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal.IExpressionTreeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal.IVisitableNode;

public class EquivalenceNode extends AbsLogicalOperatorNode<
		AbsLogicalOperatorNode,
		BinaryOperandContainer<AbsLogicalOperatorNode>
		> implements IVisitableNode {
	public EquivalenceNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitEquivalenceNode(this);
	}
}
