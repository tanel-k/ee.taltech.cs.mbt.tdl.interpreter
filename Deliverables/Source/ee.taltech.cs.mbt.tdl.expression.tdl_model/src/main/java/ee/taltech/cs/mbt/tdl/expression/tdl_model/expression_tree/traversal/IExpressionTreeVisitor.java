package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;

public interface IExpressionTreeVisitor {
	default void visitTree(ExpressionTree tree) {
		AbsExpressionNode rootNode = tree.getRootNode();
		if (rootNode instanceof IVisitableNode) {
			((IVisitableNode) rootNode).accept(this);
		}
	}

	default void visitChild(AbsExpressionNode expressionNode) {
		if (expressionNode instanceof IVisitableNode) {
			((IVisitableNode) expressionNode).accept(this);
		}
	}

	default void visitChildren(AbsExpressionNode expressionNode) {
		if (AbsOperatorNode.class.isInstance(expressionNode)) {
			AbsOperatorNode<? extends AbsExpressionNode, ?> operatorNode =
					(AbsOperatorNode<? extends AbsExpressionNode, ?>) expressionNode;
			for (AbsExpressionNode child : operatorNode.getOperandContainer().getListView()) {
				visitChild(child);
			}
		}
	}

	void visitConjunctionNode(ConjunctionNode conjunctionNode);

	void visitDisjunctionNode(DisjunctionNode disjunctionNode);

	void visitEquivalenceNode(EquivalenceNode equivalenceNode);

	void visitImplicationNode(ImplicationNode implicationNode);

	void visitBoundedLeadsToNode(BoundedLeadsToNode boundedLeadsToNode);

	void visitLeadsToNode(LeadsToNode leadsToNode);

	void visitBoundedRepetitionNode(BoundedRepetitionNode boundedRepetitionNode);

	void visitUniversalQuantificationNode(UniversalQuantificationNode universalQuantificationNode);

	void visitExistentialQuantificationNode(ExistentialQuantificationNode existentialQuantificationNode);

	void visitAbsoluteComplementNode(AbsoluteComplementNode absoluteComplementNode);

	void visitLinkedPairNode(LinkedPairNode linkedPairNode);

	void visitRelativeComplementNode(RelativeComplementNode relativeComplementNode);

	void visitTrapsetSymbolNode(TrapsetSymbolNode trapsetSymbolNode);
}
