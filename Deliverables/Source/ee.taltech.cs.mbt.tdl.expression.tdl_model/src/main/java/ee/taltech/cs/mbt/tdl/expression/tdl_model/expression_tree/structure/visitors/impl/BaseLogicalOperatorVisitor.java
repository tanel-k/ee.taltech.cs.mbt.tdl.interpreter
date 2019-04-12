package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.*;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.OperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;

public class BaseLogicalOperatorVisitor<T> implements ILogicalOperatorVisitor<T> {
	protected T defaultResult() {
		return null;
	}

	protected T mergeResults(T previousResult, T nextResult) {
		return nextResult;
	}

	protected <C extends AbsLogicalOperatorNode,
			O extends AbsLogicalOperatorNode<C, ? extends OperandContainer<C>>
			> T visitChildren(O expr) {
		return visitChildren(defaultResult(), expr);
	}

	protected <C extends AbsLogicalOperatorNode,
			O extends AbsOperatorNode<C, ? extends OperandContainer<C>>
			> T visitChildren(T previousResult, O expr) {
		for (AbsExpressionNode childExpr : expr.getOperandContainer().getListView()) {
			previousResult = mergeResults(
					previousResult,
					((AbsLogicalOperatorNode<?, ?>) childExpr).accept(this)
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
}
