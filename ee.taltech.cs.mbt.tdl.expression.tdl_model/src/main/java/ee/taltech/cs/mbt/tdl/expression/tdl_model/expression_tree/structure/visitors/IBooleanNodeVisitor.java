package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;

public interface IBooleanNodeVisitor<T> {
	T visitBoundedLeadsTo(BoundedLeadsToNode node);
	T visitBoundedRepetition(BoundedRepetitionNode node);
	T visitConjunction(ConjunctionNode node);
	T visitDisjunction(DisjunctionNode node);
	T visitEquivalence(EquivalenceNode node);
	T visitGroup(GroupNode node);
	T visitImplication(ImplicationNode node);
	T visitLeadsTo(LeadsToNode node);
	T visitUniversalQuantification(UniversalQuantificationNode node);
	T visitExistentialQuantification(ExistentialQuantificationNode node);
	T visitValueWrapper(BooleanValueWrapperNode node);
}
