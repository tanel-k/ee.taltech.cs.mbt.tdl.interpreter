package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.IUnaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node.TrapsetSymbolNode;

public abstract class AbsUnaryTrapsetOperatorNode
	extends AbsTrapsetOperatorNode
	implements IUnaryOperatorNode<TrapsetSymbolNode>
{
	public TrapsetSymbolNode getOperand() {
		return getOperand(ORD_FIRST_OPERAND);
	}

	public void setOperand(TrapsetSymbolNode operand) {
		setOperand(ORD_FIRST_OPERAND, operand);
	}

	public AbsUnaryTrapsetOperatorNode() {
		super(ARITY_UNARY);
	}
}
