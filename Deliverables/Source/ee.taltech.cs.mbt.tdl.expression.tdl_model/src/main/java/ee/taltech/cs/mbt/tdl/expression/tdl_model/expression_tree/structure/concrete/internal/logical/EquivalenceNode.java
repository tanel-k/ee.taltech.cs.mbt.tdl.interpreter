package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.BinaryChildContainer;

public class EquivalenceNode extends AbsLogicalOperatorNode<
			AbsLogicalOperatorNode,
		BinaryChildContainer<AbsLogicalOperatorNode>
		> {
	public EquivalenceNode() {
		super(new BinaryChildContainer<>());
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitEquivalence(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitEquivalence(this);
	}

	@Override
	public EquivalenceNode deepClone() {
		EquivalenceNode clone = new EquivalenceNode();
		clone.setNegated(isNegated());
		clone.getChildContainer().setLeftOperand(getChildContainer().getLeftOperand().deepClone());
		clone.getChildContainer().setRightOperand(getChildContainer().getRightOperand().deepClone());
		return clone;
	}
}
