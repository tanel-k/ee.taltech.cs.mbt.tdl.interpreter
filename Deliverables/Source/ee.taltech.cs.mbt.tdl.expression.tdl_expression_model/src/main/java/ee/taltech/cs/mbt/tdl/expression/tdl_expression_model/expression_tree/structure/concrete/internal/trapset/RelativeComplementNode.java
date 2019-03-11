package ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.traversal.IExpressionTreeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.traversal.IVisitableNode;

public class RelativeComplementNode
		extends AbsTrapsetOperatorNode<BinaryOperandContainer<TrapsetSymbolNode>>
		implements IVisitableNode {
	public RelativeComplementNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitRelativeComplementNode(this);
	}
}
