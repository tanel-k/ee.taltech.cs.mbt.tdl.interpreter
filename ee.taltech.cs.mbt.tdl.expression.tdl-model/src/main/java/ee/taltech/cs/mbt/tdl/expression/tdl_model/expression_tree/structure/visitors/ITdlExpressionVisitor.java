package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairsNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;

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
	T visitLinkedPairs(LinkedPairsNode node);
	T visitRelativeComplement(RelativeComplementNode node);
	T visitFalse(FalseNode node);
	T visitTrue(TrueNode node);
	T visitBooleanValueWrapper(BooleanValueWrapperNode node);
	T visitTrapsetWrapper(TrapsetWrapperNode node);
}
