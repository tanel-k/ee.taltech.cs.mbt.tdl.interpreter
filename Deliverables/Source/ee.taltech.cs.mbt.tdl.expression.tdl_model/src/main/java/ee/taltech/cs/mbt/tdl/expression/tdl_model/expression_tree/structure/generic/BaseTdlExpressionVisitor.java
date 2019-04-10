package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;

public class BaseTdlExpressionVisitor<T> implements TdlExpressionVisitor<T> {
	protected T defaultResult() {
		return null;
	}

	protected T mergeResults(T previousResult, T nextResult) {
		return nextResult;
	}

	@Override
	public T visitBoundedRepetition(BoundedRepetitionNode node) {
		return null;
	}

	@Override
	public T visitConjunction(ConjunctionNode node) {
		return null;
	}

	@Override
	public T visitDisjunction(DisjunctionNode node) {
		return null;
	}

	@Override
	public T visitEquivalence(EquivalenceNode node) {
		return null;
	}

	@Override
	public T visitTrapsetSymbol(TrapsetSymbolNode node) {
		return null;
	}

	@Override
	public T visitGroup(GroupNode node) {
		return null;
	}

	@Override
	public T visitExistentialQuantification(ExistentialQuantificationNode node) {
		return null;
	}

	@Override
	public T visitUniversalQuantification(UniversalQuantificationNode node) {
		return null;
	}

	@Override
	public T visitLeadsTo(LeadsToNode node) {
		return null;
	}

	@Override
	public T visitImplication(ImplicationNode node) {
		return null;
	}

	@Override
	public T visitBoundedLeadsTo(BoundedLeadsToNode node) {
		return null;
	}

	@Override
	public T visitAbsoluteComplement(AbsoluteComplementNode node) {
		return null;
	}

	@Override
	public T visitLinkedPair(LinkedPairNode node) {
		return null;
	}

	@Override
	public T visitRelativeComplement(RelativeComplementNode node) {
		return null;
	}
}
