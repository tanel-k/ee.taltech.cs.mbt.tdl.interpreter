package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
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
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.BoundedRepetitionLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.ConjunctionLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.DisjunctionLiteralOperandEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.LeadsToLiteralOperandEliminator;

import java.util.Deque;

public class LiteralEliminator {
	public static LiteralEliminator getInstance(TdlExpression expression, Deque<BooleanValueWrapperNode> remainingBooleanLeaves) {
		return new LiteralEliminator(expression, remainingBooleanLeaves);
	}

	private class EliminatingVisitor implements IBooleanNodeVisitor<Void> {
		@Override
		public Void visitBoundedRepetition(BoundedRepetitionNode parentNode) {
			BoundedRepetitionLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			return null;
		}

		@Override
		public Void visitBoundedLeadsTo(BoundedLeadsToNode parentNode) {
			return visitLeadsTo(parentNode);
		}

		@Override
		public Void visitLeadsTo(LeadsToNode parentNode) {
			LeadsToLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			return null;
		}

		@Override
		public Void visitConjunction(ConjunctionNode parentNode) {
			ConjunctionLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			return null;
		}

		@Override
		public Void visitDisjunction(DisjunctionNode parentNode) {
			DisjunctionLiteralOperandEliminator
					.getInstance(expression, parentNode, currentLeaf, remainingBooleanLeaves)
					.eliminate();
			return null;
		}

		@Override
		public Void visitEquivalence(EquivalenceNode node) {
			throw new UnsupportedOperationException("Literal elimination for equivalence has not been implemented.");
		}

		@Override
		public Void visitGroup(GroupNode node) {
			throw new UnsupportedOperationException("Literal elimination for groups has not been implemented.");
		}

		@Override
		public Void visitImplication(ImplicationNode node) {
			throw new UnsupportedOperationException("Literal elimination for implication has not been implemented.");
		}

		@Override
		public Void visitUniversalQuantification(UniversalQuantificationNode node) {
			throw new UnsupportedOperationException("Literal elimination for quantification has not been implemented.");
		}

		@Override
		public Void visitExistentialQuantification(ExistentialQuantificationNode node) {
			throw new UnsupportedOperationException("Literal elimination for quantification has not been implemented.");
		}

		@Override
		public Void visitValueWrapper(BooleanValueWrapperNode node) {
			// Not possible in context: BooleanValueWrapperNode cannot have BooleanValueWrapperNode as its parent.
			throw new IllegalStateException("Unrecognized node layout encountered. Literal node cannot be the child of a literal node.");
		}
	}

	private BooleanFlag completionFlag = BooleanFlag.newInstance();

	private final TdlExpression expression;

	private BooleanValueWrapperNode currentLeaf;
	private Deque<BooleanValueWrapperNode> remainingBooleanLeaves;

	private LiteralEliminator(TdlExpression expression, Deque<BooleanValueWrapperNode> remainingBooleanLeaves) {
		this.expression = expression;
		this.remainingBooleanLeaves = remainingBooleanLeaves;
	}

	public void eliminate() {
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
			parentNode.accept(eliminatingVisitor);
		}

		completionFlag.set();
	}
}
