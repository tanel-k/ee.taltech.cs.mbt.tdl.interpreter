package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;

public abstract class AbsTrapsetQuantifierNode extends AbsLogicalOperatorNode<
		AbsTrapsetOperatorNode,
		UnaryChildContainer<AbsTrapsetOperatorNode>
	> {
	protected AbsTrapsetQuantifierNode() {
		super(new UnaryChildContainer<>());
	}

	@Override
	protected AbsTrapsetQuantifierNode setChildContainer(UnaryChildContainer<AbsTrapsetOperatorNode> childContainer) {
		return (AbsTrapsetQuantifierNode) super.setChildContainer(childContainer);
	}

	public abstract <T> T accept(ITrapsetQuantifierVisitor<T> visitor);

	@Override
	public abstract AbsTrapsetQuantifierNode deepClone();
}
