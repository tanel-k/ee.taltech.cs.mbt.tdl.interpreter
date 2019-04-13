package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_operator;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetOperatorVisitor;

public class LinkedPairNode extends AbsTrapsetOperatorNode<
			BinaryOperandContainer<TrapsetNode>
		> {
	public LinkedPairNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}

	@Override
	public <T> T accept(ITrapsetOperatorVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}

	@Override
	public AbsTrapsetOperatorNode<BinaryOperandContainer<TrapsetNode>> deepClone() {
		LinkedPairNode clone = new LinkedPairNode();
		clone.getOperandContainer()
				.setLeftOperand(getOperandContainer().getLeftOperand().deepClone())
				.setRightOperand(getOperandContainer().getRightOperand().deepClone());
		return clone;
	}
}
