package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;

public interface ITdlExpressionVisitor<T> {
	T visitBoundedRepetition(BoundedRepetitionNode node);
	T visitConjunction(ConjunctionNode node);
	T visitDisjunction(DisjunctionNode node);
	T visitEquivalence(EquivalenceNode node);
	T visitTrapset(TrapsetNode node);
	T visitGroup(GroupNode node);
	T visitExistentialQuantification(ExistentialQuantificationNode node);
	T visitUniversalQuantification(UniversalQuantificationNode node);
	T visitLeadsTo(LeadsToNode node);
	T visitImplication(ImplicationNode node);
	T visitBoundedLeadsTo(BoundedLeadsToNode node);
	T visitAbsoluteComplement(AbsoluteComplementNode node);
	T visitLinkedPair(LinkedPairNode node);
	T visitRelativeComplement(RelativeComplementNode node);
	T visitFalse(FalseNode node);
	T visitTrue(TrueNode node);
	T visitBooleanValueWrapper(BooleanValueWrapperNode node);
	T visitTrapsetWrapper(TrapsetWrapperNode node);
}
