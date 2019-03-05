package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.AbsOperatorNode;

public abstract class AbsExpressionTreeVisitor implements IExpressionTreeVisitor {
	public void visitTree(ExpressionTree expressionTree) {
		expressionTree.getRootNode().accept(this);
	}

	public void visitChildren(AbsOperatorNode<?> operatorNode) {
		for (AbsExpressionNode expressionNode : operatorNode.getOperandNodes()) {
			expressionNode.accept(this);
		}
	}

	public void visitChildren(AbsExpressionNode expressionNode) {
		if (expressionNode instanceof AbsOperatorNode) {
			visitChildren((AbsOperatorNode<?>) expressionNode);
		}
	}
}
