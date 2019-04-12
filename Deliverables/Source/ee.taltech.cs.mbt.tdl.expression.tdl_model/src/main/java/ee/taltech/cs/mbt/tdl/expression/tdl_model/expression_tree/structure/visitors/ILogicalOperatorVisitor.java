package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;

public interface ILogicalOperatorVisitor<T> {
	T visitBoundedLeadsTo(BoundedLeadsToNode operator);
	T visitBoundedRepetition(BoundedRepetitionNode operator);
	T visitConjunction(ConjunctionNode operator);
	T visitDisjunction(DisjunctionNode operator);
	T visitEquivalence(EquivalenceNode operator);
	T visitGroup(GroupNode operator);
	T visitImplication(ImplicationNode operator);
	T visitLeadsTo(LeadsToNode operator);
	T visitUniversalQuantification(UniversalQuantificationNode operator);
	T visitExistentialQuantification(ExistentialQuantificationNode operator);
}
