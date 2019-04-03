package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal.IExpressionTreeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal.IVisitableNode;

public class AbsoluteComplementNode
		extends AbsTrapsetOperatorNode<UnaryOperandContainer<TrapsetSymbolNode>>
		implements IVisitableNode {
	public AbsoluteComplementNode() {
		super(new UnaryOperandContainer<>());
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitAbsoluteComplementNode(this);
	}
}
