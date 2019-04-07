package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.leaf_container.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.leaf_container.UniversalQuantificationNode;

public interface TdlExpressionVisitor<T> {
	T visitBoundedRepetition(BoundedRepetitionNode node);
	T visitConjunction(ConjunctionNode node);
	T visitDisjunction(DisjunctionNode node);
	T visitEquivalence(EquivalenceNode node);
	T visitTrapsetSymbol(TrapsetSymbolNode node);
	T visitGroup(GroupNode node);
	T visitExistentialQuantification(ExistentialQuantificationNode node);
	T visitUniversalQuantification(UniversalQuantificationNode node);
	T visitLeadsTo(LeadsToNode node);
	T visitImplication(ImplicationNode node);
	T visitBoundedLeadsTo(BoundedLeadsToNode node);
	T visitAbsoluteComplement(AbsoluteComplementNode node);
	T visitLinkedPair(LinkedPairNode node);
	T visitRelativeComplement(RelativeComplementNode node);
}
