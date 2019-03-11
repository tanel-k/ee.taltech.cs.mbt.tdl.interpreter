package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public abstract class AbsOperatorNode<
		OperandType extends AbsExpressionNode,
		OperandContainerType extends OperandContainer<OperandType>
		>
		extends AbsExpressionNode {
	private final OperandContainerType operandContainer;

	public AbsOperatorNode(OperandContainerType operandContainer) {
		this.operandContainer = operandContainer;
	}

	public OperandContainerType getOperandContainer() {
		return operandContainer;
	}
}
