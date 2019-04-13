package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;

public class GroupNode extends AbsLogicalOperatorNode<
			AbsLogicalOperatorNode,
			UnaryOperandContainer<AbsLogicalOperatorNode>
		> {
	public GroupNode() {
		super(new UnaryOperandContainer<>());
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitGroup(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitGroup(this);
	}

	@Override
	public GroupNode deepClone() {
		GroupNode clone = new GroupNode();
		clone.setNegated(isNegated());
		clone.getOperandContainer().setOperand(getOperandContainer().getOperand().deepClone());
		return clone;
	}
}
