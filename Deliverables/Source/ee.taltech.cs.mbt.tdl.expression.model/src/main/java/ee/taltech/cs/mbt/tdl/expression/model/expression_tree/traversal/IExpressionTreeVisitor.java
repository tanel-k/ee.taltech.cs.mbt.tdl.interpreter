package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.leaf.TrapsetSymbolNode;

public interface IExpressionTreeVisitor {
	default void visitTree(ExpressionTree tree) {
		tree.getRootNode().accept(this);
	}

	default void visitChild(AbsExpressionNode expressionNode) {
		expressionNode.accept(this);
	}

	default void visitChildren(AbsExpressionNode expressionNode) {
		if (expressionNode instanceof AbsOperatorNode) {
			AbsOperatorNode<?> operatorNode = (AbsOperatorNode<?>) expressionNode;
			for (AbsExpressionNode operand : operatorNode.getOperandNodes()) {
				visitChild(operand);
			}
		}
	}

	void visitConjunctionNode(ConjunctionNode conjunctionNode);
	void visitDisjunctionNode(DisjunctionNode disjunctionNode);

	void visitImplicationNode(ImplicationNode implicationNode);
	void visitLeadsToBoundedNode(LeadsToBoundedNode leadsToBoundedNode);
	void visitLeadsToNode(LeadsToNode leadsToNode);
	void visitRepetitionBoundedNode(RepetitionBoundedNode repetitionBoundedNode);
	void visitUniversalQuantificationNode(UniversalQuantificationNode universalQuantificationNode);
	void visitExistentialQuantificationNode(ExistentialQuantificationNode existentialQuantificationNode);

	void visitAbsoluteComplementNode(AbsoluteComplementNode absoluteComplementNode);
	void visitLinkedPairNode(LinkedPairNode linkedPairNode);
	void visitRelativeComplementNode(RelativeComplementNode relativeComplementNode);

	void visitTrapsetSymbolNode(TrapsetSymbolNode trapsetSymbolNode);
}
