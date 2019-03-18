package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;

public class BaseExpressionTreeVisitor implements IExpressionTreeVisitor {
	@Override
	public void visitConjunctionNode(ConjunctionNode conjunctionNode) {
		visitChildren(conjunctionNode);
	}

	@Override
	public void visitEquivalenceNode(EquivalenceNode equivalenceNode) {
		visitChildren(equivalenceNode);
	}

	@Override
	public void visitDisjunctionNode(DisjunctionNode disjunctionNode) {
		visitChildren(disjunctionNode);
	}

	@Override
	public void visitImplicationNode(ImplicationNode implicationNode) {
		visitChildren(implicationNode);
	}

	@Override
	public void visitBoundedLeadsToNode(BoundedLeadsToNode boundedLeadsToNode) {
		visitChildren(boundedLeadsToNode);
	}

	@Override
	public void visitLeadsToNode(LeadsToNode leadsToNode) {
		visitChildren(leadsToNode);
	}

	@Override
	public void visitBoundedRepetitionNode(BoundedRepetitionNode boundedRepetitionNode) {
		visitChildren(boundedRepetitionNode);
	}

	@Override
	public void visitUniversalQuantificationNode(UniversalQuantificationNode universalQuantificationNode) {
		visitChildren(universalQuantificationNode);
	}

	@Override
	public void visitExistentialQuantificationNode(ExistentialQuantificationNode existentialQuantificationNode) {
		visitChildren(existentialQuantificationNode);
	}

	@Override
	public void visitAbsoluteComplementNode(AbsoluteComplementNode absoluteComplementNode) {
		visitChildren(absoluteComplementNode);
	}

	@Override
	public void visitLinkedPairNode(LinkedPairNode linkedPairNode) {
		visitChildren(linkedPairNode);
	}

	@Override
	public void visitRelativeComplementNode(RelativeComplementNode relativeComplementNode) {
		visitChildren(relativeComplementNode);
	}

	@Override
	public void visitTrapsetSymbolNode(TrapsetSymbolNode trapsetSymbolNode) {
		// NoOp
	}
}
