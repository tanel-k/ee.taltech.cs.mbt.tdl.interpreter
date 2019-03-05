package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.AbsExpressionNode;

// Better approach: AbsOperatorNode to spawn an operatorGetter object based on arity input param?
public interface IBinaryOperatorNode<O extends AbsExpressionNode> {
	public O getFirstOperand();
	public void setFirstOperand(O operand);
	public O getSecondOperand();
	public void setSecondOperand(O operand);
}
