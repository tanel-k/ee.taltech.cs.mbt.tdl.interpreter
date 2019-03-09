package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity.IUnaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class AbsoluteComplementNode extends AbsTrapsetOperatorNode<UnaryOperandContainer<TrapsetSymbolNode>> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitAbsoluteComplementNode(this);
	}

	public AbsoluteComplementNode() {
		super(new UnaryOperandContainer<>());
	}
}
