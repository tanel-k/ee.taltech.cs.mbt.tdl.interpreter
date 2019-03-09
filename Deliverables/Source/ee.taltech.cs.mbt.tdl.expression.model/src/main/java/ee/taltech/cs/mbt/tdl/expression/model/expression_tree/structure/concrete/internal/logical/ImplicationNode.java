package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity.IBinaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class ImplicationNode extends AbsLogicalOperatorNode<
		AbsLogicalOperatorNode, BinaryOperandContainer<AbsLogicalOperatorNode>>
{
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitImplicationNode(this);
	}

	public ImplicationNode() {
		super(new BinaryOperandContainer<>());
	}
}
