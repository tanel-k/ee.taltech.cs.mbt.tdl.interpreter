package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetQuantifierVisitor;

public abstract class AbsTrapsetQuantifierNode extends AbsBooleanInternalNode<
		AbsDerivedTrapsetNode,
		UnaryChildContainer<AbsDerivedTrapsetNode>
	> {
	protected AbsTrapsetQuantifierNode() {
		super(new UnaryChildContainer<>(), null);
	}

	@Override
	protected AbsTrapsetQuantifierNode setChildContainer(UnaryChildContainer<AbsDerivedTrapsetNode> childContainer) {
		return (AbsTrapsetQuantifierNode) super.setChildContainer(childContainer);
	}

	public abstract <T> T accept(IDerivedTrapsetQuantifierVisitor<T> visitor);

	@Override
	public abstract AbsTrapsetQuantifierNode deepClone();
}
