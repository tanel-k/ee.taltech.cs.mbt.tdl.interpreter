package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetOperatorVisitor;

public abstract class AbsTrapsetOperatorNode<ContainerType extends ChildContainer<TrapsetNode>>
		extends AbsOperatorNode<TrapsetNode, ContainerType> {
	protected AbsTrapsetOperatorNode(ContainerType operandContainer) {
		super(operandContainer);
	}
	public abstract <T> T accept(ITrapsetOperatorVisitor<T> visitor);

	@Override
	protected AbsTrapsetOperatorNode<ContainerType> setChildContainer(ContainerType childContainer) {
		return (AbsTrapsetOperatorNode<ContainerType>) super.setChildContainer(childContainer);
	}

	@Override
	public abstract AbsTrapsetOperatorNode<ContainerType> deepClone();
}
