package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.UniversalQuantificationNode;
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
