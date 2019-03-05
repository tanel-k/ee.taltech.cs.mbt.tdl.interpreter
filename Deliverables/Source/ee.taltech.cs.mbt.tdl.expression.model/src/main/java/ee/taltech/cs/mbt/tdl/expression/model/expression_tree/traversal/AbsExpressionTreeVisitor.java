package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.AbsExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;

public abstract class AbsExpressionTreeVisitor<T extends AbsExpressionTree<R>, R extends AbsExpressionNode>
	implements IExpressionTreeVisitor
{
	public void visitTree(T expressionTree) {
		expressionTree.getRootNode().accept(this);
	}

	public void visitChildren(AbsOperatorNode<?> operatorNode) {
		for (AbsExpressionNode expressionNode : operatorNode.getOperandNodes()) {
			expressionNode.accept(this);
		}
	}

	public void visitChild(AbsExpressionNode expressionNode) {
		expressionNode.accept(this);
	}

	public void visitChildren(AbsExpressionNode expressionNode) {
		if (expressionNode instanceof AbsOperatorNode) {
			visitChildren((AbsOperatorNode<?>) expressionNode);
		}
	}
}
