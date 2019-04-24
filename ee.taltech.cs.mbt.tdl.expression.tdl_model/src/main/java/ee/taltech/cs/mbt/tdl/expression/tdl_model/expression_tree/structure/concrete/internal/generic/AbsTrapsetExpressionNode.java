package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetExpressionVisitor;

public abstract class AbsTrapsetExpressionNode<ContainerType extends ChildContainer<TrapsetNode>>
		extends AbsInternalNode<TrapsetNode, ContainerType> {
	protected AbsTrapsetExpressionNode(ContainerType operandContainer, Boolean commutative) {
		super(operandContainer, commutative);
	}
	public abstract <T> T accept(ITrapsetExpressionVisitor<T> visitor);

	@Override
	protected AbsTrapsetExpressionNode<ContainerType> setChildContainer(ContainerType childContainer) {
		return (AbsTrapsetExpressionNode<ContainerType>) super.setChildContainer(childContainer);
	}

	@Override
	public abstract AbsTrapsetExpressionNode<ContainerType> deepClone();
}
