package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.logical.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.trapset.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node.*;

public class StubExpressionTreeVisitor extends AbsExpressionTreeVisitor {
	@Override
	public void visitConjunctionNode(ConjunctionNode conjunctionNode) {
		visitChildren(conjunctionNode);
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
	public void visitLeadsToBoundedNode(LeadsToBoundedNode leadsToBoundedNode) {
		visitChildren(leadsToBoundedNode);
	}

	@Override
	public void visitLeadsToNode(LeadsToNode leadsToNode) {
		visitChildren(leadsToNode);
	}

	@Override
	public void visitRepetitionBoundedNode(RepetitionBoundedNode repetitionBoundedNode) {
		visitChildren(repetitionBoundedNode);
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
