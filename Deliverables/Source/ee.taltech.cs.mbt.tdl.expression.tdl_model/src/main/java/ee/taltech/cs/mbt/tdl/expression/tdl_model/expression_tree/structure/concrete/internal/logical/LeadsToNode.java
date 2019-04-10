package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;

public class LeadsToNode extends AbsLogicalOperatorNode<
			AbsLogicalOperatorNode,
			BinaryOperandContainer<AbsLogicalOperatorNode>
		> {
	public LeadsToNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public <T> T accept(TdlExpressionVisitor<T> visitor) {
		return visitor.visitLeadsTo(this);
	}
}
