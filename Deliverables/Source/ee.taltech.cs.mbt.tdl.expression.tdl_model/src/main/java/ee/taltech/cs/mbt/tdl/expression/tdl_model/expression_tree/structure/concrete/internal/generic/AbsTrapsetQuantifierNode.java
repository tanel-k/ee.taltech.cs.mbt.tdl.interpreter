package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;

public abstract class AbsTrapsetQuantifierNode extends AbsLogicalOperatorNode<
		AbsTrapsetOperatorNode,
		UnaryOperandContainer<AbsTrapsetOperatorNode>
	> {
	protected AbsTrapsetQuantifierNode() {
		super(new UnaryOperandContainer<>());
	}

	@Override
	protected AbsTrapsetQuantifierNode setOperandContainer(UnaryOperandContainer<AbsTrapsetOperatorNode> operandContainer) {
		return (AbsTrapsetQuantifierNode) super.setOperandContainer(operandContainer);
	}

	public abstract <T> T accept(ITrapsetQuantifierVisitor<T> visitor);

	@Override
	public abstract AbsTrapsetQuantifierNode deepClone();
}
