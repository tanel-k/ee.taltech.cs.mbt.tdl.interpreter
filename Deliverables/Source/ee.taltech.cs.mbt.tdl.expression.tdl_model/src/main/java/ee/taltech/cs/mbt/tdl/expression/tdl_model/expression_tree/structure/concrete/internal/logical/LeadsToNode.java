package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;

public class LeadsToNode extends AbsLogicalOperatorNode<
			AbsLogicalOperatorNode,
			BinaryOperandContainer<AbsLogicalOperatorNode>
		> {
	public LeadsToNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitLeadsTo(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitLeadsTo(this);
	}

	@Override
	public LeadsToNode deepClone() {
		LeadsToNode clone = new LeadsToNode();
		clone.setNegated(isNegated());
		clone.getOperandContainer().setLeftOperand(getOperandContainer().getLeftOperand().deepClone());
		clone.getOperandContainer().setRightOperand(getOperandContainer().getRightOperand().deepClone());
		return clone;
	}
}
