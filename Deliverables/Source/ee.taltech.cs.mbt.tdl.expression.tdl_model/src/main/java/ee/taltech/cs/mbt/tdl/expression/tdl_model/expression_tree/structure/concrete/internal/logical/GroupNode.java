package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;

public class GroupNode extends AbsLogicalOperatorNode<
			AbsLogicalOperatorNode,
			UnaryOperandContainer<AbsLogicalOperatorNode>
		> {
	public GroupNode() {
		super(new UnaryOperandContainer<>());
	}

	@Override
	public <T> T accept(TdlExpressionVisitor<T> visitor) {
		return visitor.visitGroup(this);
	}
}
