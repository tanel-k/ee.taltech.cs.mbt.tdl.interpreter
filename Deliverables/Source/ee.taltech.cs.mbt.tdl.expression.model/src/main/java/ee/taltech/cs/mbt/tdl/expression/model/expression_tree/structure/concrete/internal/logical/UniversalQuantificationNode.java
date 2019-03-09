package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity.IUnaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class UniversalQuantificationNode extends AbsLogicalOperatorNode<
		AbsTrapsetOperatorNode, UnaryOperandContainer<AbsTrapsetOperatorNode>>
{
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitUniversalQuantificationNode(this);
	}

	public UniversalQuantificationNode() {
		super(new UnaryOperandContainer<>());
	}
}
