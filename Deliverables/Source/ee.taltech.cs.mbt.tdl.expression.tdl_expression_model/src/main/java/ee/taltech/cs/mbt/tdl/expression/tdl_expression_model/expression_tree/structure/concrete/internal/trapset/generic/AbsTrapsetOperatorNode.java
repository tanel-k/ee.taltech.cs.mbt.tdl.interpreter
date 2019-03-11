package ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.trapset.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public abstract class AbsTrapsetOperatorNode<ContainerType extends OperandContainer<TrapsetSymbolNode>>
		extends AbsOperatorNode<TrapsetSymbolNode, ContainerType> {
	public AbsTrapsetOperatorNode(ContainerType operandContainer) {
		super(operandContainer);
	}
}
