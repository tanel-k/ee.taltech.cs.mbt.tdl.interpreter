package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.BoundedLeadsToNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.BoundedRepetitionNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.ConjunctionNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.DisjunctionNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.EquivalenceNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.GroupNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.ImplicationNormalizingReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers.LeadsToNormalizingReducer;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionNormalizer {
	public static ExpressionNormalizer getInstance(TdlExpression expression) {
		return new ExpressionNormalizer(expression);
	}

	public static ExpressionNormalizer getInstance(TdlExpression expression, AbsBooleanInternalNode subtreeRoot) {
		return new ExpressionNormalizer(expression, subtreeRoot);
	}

	@SuppressWarnings("unchecked")
	private class NormalizingVisitor extends BaseBooleanNodeVisitor<Void> {
		private TdlExpression expression;
		private Deque<BooleanValueWrapperNode> leafNodeStorage;

		NormalizingVisitor(TdlExpression expression, Deque<BooleanValueWrapperNode> valueWrapperStorage) {
			this.expression = expression;
			this.leafNodeStorage = valueWrapperStorage;
		}

		@Override
		public Void visitValueWrapper(BooleanValueWrapperNode valueWrapper) {
			leafNodeStorage.add(valueWrapper);
			return null;
		}

		@Override
		public Void visitGroup(GroupNode group) {
			GroupNormalizingReducer.getInstance()
					.reduce(expression, group).accept(this);
			return null;
		}

		@Override
		public Void visitConjunction(ConjunctionNode conjunction) {
			return visitChildren(
					ConjunctionNormalizingReducer.getInstance()
							.reduce(expression, conjunction)
			);
		}

		@Override
		public Void visitDisjunction(DisjunctionNode disjunction) {
			return visitChildren(
					DisjunctionNormalizingReducer.getInstance()
							.reduce(expression, disjunction)
			);
		}

		@Override
		public Void visitImplication(ImplicationNode implication) {
			return visitChildren(
					ImplicationNormalizingReducer.getInstance()
							.reduce(expression, implication)
			);
		}

		@Override
		public Void visitEquivalence(EquivalenceNode equivalence) {
			return visitChildren(
					EquivalenceNormalizingReducer.getInstance()
							.reduce(expression, equivalence)
			);
		}

		@Override
		public Void visitBoundedRepetition(BoundedRepetitionNode boundedRepetition) {
			return visitChildren(
					BoundedRepetitionNormalizingReducer.getInstance()
							.reduce(expression, boundedRepetition)
			);
		}

		@Override
		public Void visitLeadsTo(LeadsToNode leadsTo) {
			return visitChildren(
					LeadsToNormalizingReducer.getInstance()
							.reduce(expression, leadsTo)
			);
		}

		@Override
		public Void visitBoundedLeadsTo(BoundedLeadsToNode boundedLeadsTo) {
			return visitChildren(
					BoundedLeadsToNormalizingReducer.getInstance()
							.reduce(expression, boundedLeadsTo)
			);
		}
	}

	private Flag completionFlag = Flag.newInstance();

	private final TdlExpression expression;
	private final AbsBooleanInternalNode subtreeRoot;
	private Deque<BooleanValueWrapperNode> booleanValueWrappers = new LinkedList<>();

	private ExpressionNormalizer(TdlExpression expression) {
		this(expression, expression.getRootNode());
	}

	private ExpressionNormalizer(TdlExpression expression, AbsBooleanInternalNode subtreeRoot) {
		this.expression = expression;
		this.subtreeRoot = subtreeRoot;
	}

	public Deque<BooleanValueWrapperNode> normalize() {
		if (completionFlag.isSet())
			return booleanValueWrappers;

		NormalizingVisitor normalizingVisitor = new NormalizingVisitor(expression, booleanValueWrappers);
		subtreeRoot.accept(normalizingVisitor);

		completionFlag.set();
		return booleanValueWrappers;
	}
}
