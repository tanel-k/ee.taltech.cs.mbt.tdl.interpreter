package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination;

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
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.impl.BoundedLeadsToLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.impl.BoundedRepetitionLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.impl.ConjunctionLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.impl.DisjunctionLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.impl.LeadsToLiteralOperandEliminator;

import java.util.Deque;

public class LiteralEliminator {
	private class TunneledLiteralEliminationException extends RuntimeException {
		private LiteralEliminationException cause;
		TunneledLiteralEliminationException(LiteralEliminationException ex) {
			this.cause = ex;
		}
	}

	public static LiteralEliminator getInstance(TdlExpression expression, Deque<BooleanValueWrapperNode> remainingBooleanLeaves) {
		return new LiteralEliminator(expression, remainingBooleanLeaves);
	}

	private class EliminatingVisitor implements IBooleanNodeVisitor<Void> {
		@Override
		public Void visitBoundedRepetition(BoundedRepetitionNode parentNode) {
			try {
				BoundedRepetitionLiteralOperandEliminator
						.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
						.eliminate();
			} catch (LiteralEliminationException ex) {
				throw new TunneledLiteralEliminationException(ex);
			}
			return null;
		}

		@Override
		public Void visitBoundedLeadsTo(BoundedLeadsToNode parentNode) {
			try {
				BoundedLeadsToLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			} catch (LiteralEliminationException ex) {
				throw new TunneledLiteralEliminationException(ex);
			}
			return null;
		}

		@Override
		public Void visitLeadsTo(LeadsToNode parentNode) {
			try {
				LeadsToLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			} catch (LiteralEliminationException ex) {
				throw new TunneledLiteralEliminationException(ex);
			}
			return null;
		}

		@Override
		public Void visitConjunction(ConjunctionNode parentNode) {
			try {
				ConjunctionLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			} catch (LiteralEliminationException ex) {
				throw new TunneledLiteralEliminationException(ex);
			}
			return null;
		}

		@Override
		public Void visitDisjunction(DisjunctionNode parentNode) {
			try {
				DisjunctionLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			} catch (LiteralEliminationException ex) {
				throw new TunneledLiteralEliminationException(ex);
			}
			return null;
		}

		@Override
		public Void visitEquivalence(EquivalenceNode node) {
			// A call shouldn't occur during normal operation but throw an exception just in case:
			throw new TunneledLiteralEliminationException(
					new LiteralEliminationException(
							"Literal elimination for equivalence has not been implemented.",
							expression,
							node,
							currentLeaf
					)
			);
		}

		@Override
		public Void visitGroup(GroupNode node) {
			// A call shouldn't occur during normal operation but throw an exception just in case:
			throw new TunneledLiteralEliminationException(
					new LiteralEliminationException(
							"Literal elimination for groups has not been implemented.",
							expression,
							node,
							currentLeaf
					)
			);
		}

		@Override
		public Void visitImplication(ImplicationNode node) {
			// A call shouldn't occur during normal operation but throw an exception just in case:
			throw new TunneledLiteralEliminationException(
					new LiteralEliminationException(
							"Literal elimination for implication has not been implemented.",
							expression,
							node,
							currentLeaf
					)
			);
		}

		@Override
		public Void visitUniversalQuantification(UniversalQuantificationNode node) {
			// A call shouldn't occur during normal operation but throw an exception just in case:
			throw new TunneledLiteralEliminationException(
					new LiteralEliminationException(
							"Literal elimination for quantification has not been implemented.",
							expression,
							node,
							currentLeaf
					)
			);
		}

		@Override
		public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
			// A call shouldn't occur during normal operation but throw an exception just in case:
			throw new TunneledLiteralEliminationException(
					new LiteralEliminationException(
							"Literal elimination for quantification has not been implemented.",
							expression,
							node,
							currentLeaf
					)
			);
		}

		@Override
		public Void visitValueWrapper(BooleanValueWrapperNode node) {
			// Not possible in context: BooleanValueWrapperNode cannot have BooleanValueWrapperNode as its parent.
			throw new TunneledLiteralEliminationException(
					new LiteralEliminationException(
						"Unrecognized node layout encountered. Literal node cannot be the child of another literal node.",
						expression,
						node,
						currentLeaf
					)
			);
		}
	}

	private Flag completionFlag = Flag.newInstance();

	private final TdlExpression expression;

	private BooleanValueWrapperNode currentLeaf;
	private Deque<BooleanValueWrapperNode> remainingBooleanLeaves;

	private LiteralEliminator(TdlExpression expression, Deque<BooleanValueWrapperNode> remainingBooleanLeaves) {
		this.expression = expression;
		this.remainingBooleanLeaves = remainingBooleanLeaves;
	}

	public void eliminate() throws LiteralEliminationException {
		if (completionFlag.isSet())
			return;

		EliminatingVisitor eliminatingVisitor = new EliminatingVisitor();
		while (!remainingBooleanLeaves.isEmpty()) {
			currentLeaf = remainingBooleanLeaves.pollFirst();

			// Entire tree has been reduced:
			if (currentLeaf == expression.getRootNode())
				return;

			/*
			 * Imagine the following scenario:
			 *      /
			 *     op
			 *    /  \
			 * leafA leafB
			 * queue[leafA, leafB] -> leafA.
			 * processLeaf(leafA).
			 * queue[leafB]
			 *
			 * If processLeaf(leafA) causes <op> to be replaced with <op'>,
			 * the subtree will look like this:
			 *      /
			 *    op'
			 * but leafB will still be in the dequeue, waiting for processing, even though it is no
			 * longer attached to the tree.
			 *
			 * We use TdlExpression.isDescendant(...) to check whether the node is still inside the tree.
			 * This will entail a walk from leaf to root and while not 100% efficient,
			 * it is still better than processing an entire discarded subtree.
			 */
			if (!expression.isDescendant(currentLeaf))
				continue;

			AbsBooleanInternalNode parentNode = (AbsBooleanInternalNode) currentLeaf.getParentNode();
			try {
				parentNode.accept(eliminatingVisitor);
			} catch (TunneledLiteralEliminationException ex) {
				throw ex.cause;
			}
		}

		completionFlag.set();
	}
}
