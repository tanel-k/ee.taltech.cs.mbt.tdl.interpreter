package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;

public class EquivalenceNode extends AbsBooleanInternalNode<
		AbsBooleanInternalNode,
				BinaryChildContainer<AbsBooleanInternalNode>
		> {
	public EquivalenceNode() {
		super(new BinaryChildContainer<>(), true);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitEquivalence(this);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitEquivalence(this);
	}

	@Override
	public EquivalenceNode deepClone() {
		EquivalenceNode clone = new EquivalenceNode();
		clone.setNegated(isNegated());
		clone.getChildContainer().setLeftChild(getChildContainer().getLeftChild().deepClone());
		clone.getChildContainer().setRightChild(getChildContainer().getRightChild().deepClone());
		return clone;
	}
}
