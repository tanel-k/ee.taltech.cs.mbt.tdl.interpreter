package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

import java.math.BigInteger;
import java.util.Deque;

public class BoundedRepetitionLiteralOperandEliminator extends AbsLiteralOperandEliminator<BoundedRepetitionNode> {
	public static BoundedRepetitionLiteralOperandEliminator getInstance(
			TdlExpression expression,
			BoundedRepetitionNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		return new BoundedRepetitionLiteralOperandEliminator(expression, parentNode, childLeaf, remainingLeaves);
	}

	private BoundedRepetitionLiteralOperandEliminator(
			TdlExpression expression,
			BoundedRepetitionNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		super(expression, parentNode, childLeaf, remainingLeaves);
	}

	@Override
	protected void eliminate(
			TdlExpression expression,
			BoundedRepetitionNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		// FIXME: Double-check.
		Bound bound = parentNode.getBound();

		BigInteger boundValue = bound.getBoundValue();
		BooleanValueWrapperNode replacement = null;
		switch (bound.getBoundType()) {
			case LESS_THAN:
				// #[<n]True ==> n > 0.
				// #[<n]False ==> n > 0.
				replacement = BooleanValueWrapperNode.of(
						BigInteger.ZERO.compareTo(boundValue) < 0
				);
				break;
			case GREATER_THAN:
				if (childLeaf.wrapsFalse()) // #[>n]False ==> False.
					replacement = BooleanValueWrapperNode.falseWrapper();
				// #[>n]True ==> length(traceSinceLastCount) > n.
				break;
			case LESS_THAN_OR_EQUAL_TO:
				// #[<=n]True ==> True.
				// #[<=n]False ==> True.
				replacement = BooleanValueWrapperNode.trueWrapper();
				break;
			case GREATER_THAN_OR_EQUAL_TO:
			case EQUALS:
				// #[>=n]False ==> n == 0.
				// #[=n]False ==> n == 0.
				if (childLeaf.wrapsFalse())
					replacement = BooleanValueWrapperNode.of(
							BigInteger.ZERO.equals(boundValue)
					);
				// #[>=n]True ==> length(traceSinceLastCount) >= n.
				// #[=n]True ==> length(traceSinceLastCount) == 0.
				break;
		}

		/*
		 * Abstraction leak:
		 * We leave #[>n]True, #[>=n]True, #[=n]True as is without removing boolean leafs
		 * because we know True will be replaced with TdlTerminatorChannelAdapter.
		 * The latter fires a synch on every transition
		 * - this will help us ensure we have the appropriate trace segment length.
		 */

		if (replacement != null) {
			expression.replaceDescendant(parentNode, replacement);
			remainingLeaves.addFirst(replacement);
		}
	}
}
