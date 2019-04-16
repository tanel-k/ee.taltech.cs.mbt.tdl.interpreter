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
	public T visitBoundedLeadsTo(BoundedLeadsToNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitBoundedRepetition(BoundedRepetitionNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitConjunction(ConjunctionNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitDisjunction(DisjunctionNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitEquivalence(EquivalenceNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitGroup(GroupNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitImplication(ImplicationNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitLeadsTo(LeadsToNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitUniversalQuantification(UniversalQuantificationNode node) {
		return defaultResult();
	}

	@Override
	public T visitExistentialQuantification(ExistentialQuantificationNode node) {
		return defaultResult();
	}

	@Override
	public T visitValueWrapper(BooleanValueWrapperNode node) {
		return defaultResult();
	}
}
