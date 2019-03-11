package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IVisitableNode;

public class ExistentialQuantificationNode extends AbsLogicalOperatorNode<
		AbsTrapsetOperatorNode,
		UnaryOperandContainer<AbsTrapsetOperatorNode>
		> implements IVisitableNode {
	public ExistentialQuantificationNode() {
		super(new UnaryOperandContainer<>());
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitExistentialQuantificationNode(this);
	}
}
