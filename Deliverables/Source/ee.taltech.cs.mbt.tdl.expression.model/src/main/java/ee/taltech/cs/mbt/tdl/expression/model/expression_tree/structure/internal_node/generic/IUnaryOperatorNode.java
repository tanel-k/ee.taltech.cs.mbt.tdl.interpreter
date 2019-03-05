package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.AbsExpressionNode;

// Better approach: AbsOperatorNode to spawn an operatorGetter object based on arity input param?
public interface IUnaryOperatorNode<O extends AbsExpressionNode> {
	public O getOperand();
	public void setOperand(O operand);
}
