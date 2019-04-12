package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.OperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetOperatorVisitor;

public abstract class AbsTrapsetOperatorNode<ContainerType extends OperandContainer<TrapsetSymbolNode>>
		extends AbsOperatorNode<TrapsetSymbolNode, ContainerType> {
	protected AbsTrapsetOperatorNode(ContainerType operandContainer) {
		super(operandContainer);
	}
	public abstract <T> T accept(ITrapsetOperatorVisitor<T> visitor);
}
