package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical.*;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.leaf.TrapsetSymbolNode;

public interface IExpressionTreeVisitor {
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
