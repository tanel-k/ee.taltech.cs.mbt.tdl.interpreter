package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl;

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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class BaseTdlExpressionVisitor<T> implements ITdlExpressionVisitor<T> {
	protected T defaultResult() {
		return null;
	}

	protected T mergeResults(T previousResult, T nextResult) {
		return nextResult;
	}

	protected <C extends AbsExpressionNode,
			O extends AbsInternalNode<C, ? extends ChildContainer<C>>
	> T visitChildren(O expr) {
		return visitChildren(defaultResult(), expr);
	}

	protected <C extends AbsExpressionNode,
			O extends AbsInternalNode<C, ? extends ChildContainer<C>>
			> T visitChildren(T previousResult, O expr) {
		for (AbsExpressionNode childExpr : expr.getChildContainer().getListView()) {
			previousResult = mergeResults(previousResult, childExpr.accept(this));
		}
		return previousResult;
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
	public T visitExistentialQuantification(ExistentialQuantificationNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitUniversalQuantification(UniversalQuantificationNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitLeadsTo(LeadsToNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitImplication(ImplicationNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitBoundedLeadsTo(BoundedLeadsToNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitAbsoluteComplement(AbsoluteComplementNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitLinkedPair(LinkedPairNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitRelativeComplement(RelativeComplementNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitTrapsetWrapper(TrapsetWrapperNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitBooleanValueWrapper(BooleanValueWrapperNode node) {
		return visitChildren(node);
	}

	@Override
	public T visitFalse(FalseNode node) {
		return defaultResult();
	}

	@Override
	public T visitTrue(TrueNode node) {
		return defaultResult();
	}

	@Override
	public T visitTrapset(TrapsetNode node) {
		return defaultResult();
	}
}
