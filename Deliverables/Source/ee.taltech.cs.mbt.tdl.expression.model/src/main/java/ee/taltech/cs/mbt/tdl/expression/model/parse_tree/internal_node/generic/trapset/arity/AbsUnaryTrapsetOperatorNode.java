package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.trapset.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.AbsUnaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.IUnaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.trapset.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.TrapsetSymbolNode;

public abstract class AbsUnaryTrapsetOperatorNode
	extends AbsTrapsetOperatorNode
	implements IUnaryOperator<TrapsetSymbolNode>
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
