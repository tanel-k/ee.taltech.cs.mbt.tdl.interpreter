package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetExpressionVisitor;

public class LinkedPairsNode extends AbsTrapsetExpressionNode<
		BinaryChildContainer<TrapsetNode>
		> {
	public LinkedPairsNode() {
		super(new BinaryChildContainer<>(), Boolean.FALSE);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitLinkedPairs(this);
	}

	@Override
	public <T> T accept(ITrapsetExpressionVisitor<T> visitor) {
		return visitor.visitLinkedPairs(this);
	}

	@Override
	public AbsTrapsetExpressionNode<BinaryChildContainer<TrapsetNode>> deepClone() {
		LinkedPairsNode clone = new LinkedPairsNode();
		clone.getChildContainer()
				.setLeftChild(getChildContainer().getLeftChild().deepClone())
				.setRightChild(getChildContainer().getRightChild().deepClone());
		return clone;
	}
	@Override
	public String getHumanReadableName() {
		return "Linked Pairs";
	}

}
