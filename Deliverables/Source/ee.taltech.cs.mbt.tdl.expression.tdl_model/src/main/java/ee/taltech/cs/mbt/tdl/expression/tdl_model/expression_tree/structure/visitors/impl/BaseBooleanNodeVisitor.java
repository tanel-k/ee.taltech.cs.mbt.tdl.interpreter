package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;

public class BaseBooleanNodeVisitor<T> implements IBooleanNodeVisitor<T> {
	protected T defaultResult() {
		return null;
	}

	protected T mergeResults(T previousResult, T nextResult) {
		return nextResult;
	}

	protected <C extends AbsBooleanInternalNode,
			O extends AbsBooleanInternalNode<C, ? extends ChildContainer<C>>
			> T visitChildren(O expr) {
		return visitChildren(defaultResult(), expr);
	}

	protected <C extends AbsBooleanInternalNode,
			O extends AbsInternalNode<C, ? extends ChildContainer<C>>
			> T visitChildren(T previousResult, O expr) {
		for (AbsExpressionNode childExpr : expr.getChildContainer().getListView()) {
			previousResult = mergeResults(
					previousResult,
					((AbsBooleanInternalNode<?, ?>) childExpr).accept(this)
			);
		}
		return previousResult;
	}

	@Override
	public T visitBoundedLeadsTo(BoundedLeadsToNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitBoundedRepetition(BoundedRepetitionNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitConjunction(ConjunctionNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitDisjunction(DisjunctionNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitEquivalence(EquivalenceNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitGroup(GroupNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitImplication(ImplicationNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitLeadsTo(LeadsToNode operator) {
		return visitChildren(operator);
	}

	@Override
	public T visitUniversalQuantification(UniversalQuantificationNode operator) {
		return defaultResult();
	}

	@Override
	public T visitExistentialQuantification(ExistentialQuantificationNode operator) {
		return defaultResult();
	}

	@Override
	public T visitValueWrapper(BooleanValueWrapperNode node) {
		return defaultResult();
	}
}
