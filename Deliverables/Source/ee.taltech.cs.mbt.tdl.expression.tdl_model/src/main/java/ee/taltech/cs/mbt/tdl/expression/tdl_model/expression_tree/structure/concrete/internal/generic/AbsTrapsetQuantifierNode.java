package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;

public abstract class AbsTrapsetQuantifierNode extends AbsBooleanInternalNode<
		AbsTrapsetExpressionNode,
		UnaryChildContainer<AbsTrapsetExpressionNode>
	> {
	protected AbsTrapsetQuantifierNode() {
		super(new UnaryChildContainer<>(), null);
	}

	@Override
	protected AbsTrapsetQuantifierNode setChildContainer(UnaryChildContainer<AbsTrapsetExpressionNode> childContainer) {
		return (AbsTrapsetQuantifierNode) super.setChildContainer(childContainer);
	}

	public abstract <T> T accept(ITrapsetQuantifierVisitor<T> visitor);

	@Override
	public abstract AbsTrapsetQuantifierNode deepClone();
}
