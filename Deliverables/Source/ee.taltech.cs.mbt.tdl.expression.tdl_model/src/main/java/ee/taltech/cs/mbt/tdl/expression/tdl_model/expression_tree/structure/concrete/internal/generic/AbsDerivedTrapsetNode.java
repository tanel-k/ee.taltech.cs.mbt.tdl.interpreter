package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;

public abstract class AbsDerivedTrapsetNode<ContainerType extends ChildContainer<TrapsetNode>>
		extends AbsInternalNode<TrapsetNode, ContainerType> {
	protected AbsDerivedTrapsetNode(ContainerType operandContainer, Boolean commutative) {
		super(operandContainer, commutative);
	}
	public abstract <T> T accept(IDerivedTrapsetVisitor<T> visitor);

	@Override
	protected AbsDerivedTrapsetNode<ContainerType> setChildContainer(ContainerType childContainer) {
		return (AbsDerivedTrapsetNode<ContainerType>) super.setChildContainer(childContainer);
	}

	@Override
	public abstract AbsDerivedTrapsetNode<ContainerType> deepClone();
}
