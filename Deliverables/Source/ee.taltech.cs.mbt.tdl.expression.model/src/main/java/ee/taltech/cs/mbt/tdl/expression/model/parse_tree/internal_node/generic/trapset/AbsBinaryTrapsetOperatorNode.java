package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.IBinaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.TrapsetSymbolNode;

public abstract class AbsBinaryTrapsetOperatorNode
	extends AbsTrapsetOperatorNode
	implements IBinaryOperatorNode<TrapsetSymbolNode>
{
	@Override
	public TrapsetSymbolNode getFirstOperand() {
		return getOperand(ORD_FIRST_OPERAND);
	}

	@Override
	public void setFirstOperand(TrapsetSymbolNode operand) {
		setOperand(ORD_FIRST_OPERAND, operand);
	}

	@Override
	public TrapsetSymbolNode getSecondOperand() {
		return getOperand(ORD_SECOND_OPERAND);
	}

	@Override
	public void setSecondOperand(TrapsetSymbolNode operand) {
		setOperand(ORD_SECOND_OPERAND, operand);
	}

	public AbsBinaryTrapsetOperatorNode() {
		super(ARITY_BINARY);
	}
}
