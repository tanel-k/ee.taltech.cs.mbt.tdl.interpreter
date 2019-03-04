package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.IUnaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.TrapsetSymbolNode;

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
