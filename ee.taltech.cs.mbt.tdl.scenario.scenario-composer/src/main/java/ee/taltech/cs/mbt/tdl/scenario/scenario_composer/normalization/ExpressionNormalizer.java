package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization;

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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.BoundedLeadsToNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.BoundedRepetitionNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.ConjunctionNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.DisjunctionNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.EquivalenceNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.GroupNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.ImplicationNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl.LeadsToNormalizer;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionNormalizer {
	private class TunneledNormalizationException extends RuntimeException {
		private NormalizationException cause;
		TunneledNormalizationException(NormalizationException cause) {
			this.cause = cause;
		}
	}

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

		private Void visitChildren(AbsBooleanInternalNode prev, AbsBooleanInternalNode replacement) {
			if (prev != replacement) {
				return (Void) replacement.accept(this);
			} else {
				return visitChildren(replacement);
			}
		}

		@Override
		public Void visitValueWrapper(BooleanValueWrapperNode valueWrapper) {
			leafNodeStorage.add(valueWrapper);
			return null;
		}

		@Override
		public Void visitGroup(GroupNode group) {
			GroupNormalizer.getInstance()
					.normalize(expression, group).accept(this);
			return null;
		}

		@Override
		public Void visitConjunction(ConjunctionNode conjunction) {
			return visitChildren(
					conjunction,
					ConjunctionNormalizer.getInstance()
							.normalize(expression, conjunction)
			);
		}

		@Override
		public Void visitDisjunction(DisjunctionNode disjunction) {
			return visitChildren(
					disjunction,
					DisjunctionNormalizer.getInstance()
							.normalize(expression, disjunction)
			);
		}

		@Override
		public Void visitImplication(ImplicationNode implication) {
			return visitChildren(
					implication,
					ImplicationNormalizer.getInstance()
							.normalize(expression, implication)
			);
		}

		@Override
		public Void visitEquivalence(EquivalenceNode equivalence) {
			return visitChildren(
					equivalence,
					EquivalenceNormalizer.getInstance()
							.normalize(expression, equivalence)
			);
		}

		@Override
		public Void visitBoundedRepetition(BoundedRepetitionNode boundedRepetition) {
			return visitChildren(
					boundedRepetition,
					BoundedRepetitionNormalizer.getInstance()
							.normalize(expression, boundedRepetition)
			);
		}

		@Override
		public Void visitLeadsTo(LeadsToNode leadsTo) {
			try {
				return visitChildren(
						leadsTo,
						LeadsToNormalizer.getInstance()
								.normalize(expression, leadsTo)
				);
			} catch (NormalizationException ex) {
				throw new TunneledNormalizationException(ex);
			}
		}

		@Override
		public Void visitBoundedLeadsTo(BoundedLeadsToNode boundedLeadsTo) {
			try {
				return visitChildren(
						boundedLeadsTo,
						BoundedLeadsToNormalizer.getInstance()
								.normalize(expression, boundedLeadsTo)
				);
			} catch (NormalizationException ex) {
				throw new TunneledNormalizationException(ex);
			}
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

	public Deque<BooleanValueWrapperNode> normalize() throws NormalizationException {
		if (completionFlag.isSet())
			return booleanValueWrappers;

		NormalizingVisitor normalizingVisitor = new NormalizingVisitor(expression, booleanValueWrappers);
		try {
			subtreeRoot.accept(normalizingVisitor);
		} catch (TunneledNormalizationException tEx) {
			throw tEx.cause;
		}

		completionFlag.set();
		return booleanValueWrappers;
	}
}
