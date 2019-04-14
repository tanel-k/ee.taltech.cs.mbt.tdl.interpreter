package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;

public class LinkedPairNode extends AbsDerivedTrapsetNode<
		BinaryChildContainer<TrapsetNode>
		> {
	public LinkedPairNode() {
		super(new BinaryChildContainer<>(), Boolean.FALSE);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}

	@Override
	public <T> T accept(IDerivedTrapsetVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}

	@Override
	public AbsDerivedTrapsetNode<BinaryChildContainer<TrapsetNode>> deepClone() {
		LinkedPairNode clone = new LinkedPairNode();
		clone.getChildContainer()
				.setLeftChild(getChildContainer().getLeftChild().deepClone())
				.setRightChild(getChildContainer().getRightChild().deepClone());
		return clone;
	}
}
