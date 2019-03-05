package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.IUnaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.leaf.TrapsetSymbolNode;

public abstract class AbsUnaryTrapsetOperatorNode
	extends AbsTrapsetOperatorNode
	implements IUnaryOperatorNode<TrapsetSymbolNode>
{
	public TrapsetSymbolNode getOperand() {
		return getOperand(AbsOperatorNode.ORD_FIRST_OPERAND);
	}

	public void setOperand(TrapsetSymbolNode operand) {
		setOperand(AbsOperatorNode.ORD_FIRST_OPERAND, operand);
	}

	public AbsUnaryTrapsetOperatorNode() {
		super(AbsOperatorNode.ARITY_UNARY);
	}
}
