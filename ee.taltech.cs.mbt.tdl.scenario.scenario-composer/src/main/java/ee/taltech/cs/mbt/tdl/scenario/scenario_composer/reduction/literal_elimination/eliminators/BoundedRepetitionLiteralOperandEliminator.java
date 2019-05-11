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
		Bound bound = parentNode.getBound();

		BigInteger boundValue = bound.getBoundValue();
		BooleanValueWrapperNode replacement = null;
		switch (bound.getBoundType()) {
			case LESS_THAN:
				// #[<n]True reduces to n > 0.
				// #[<n]False reduces to n > 0.
				replacement = BooleanValueWrapperNode.of(
						BigInteger.ZERO.compareTo(boundValue) < 0
				);
				break;
			case GREATER_THAN:
				// #[>n]False reduces to False.
				// #[>n]True reduces to True (in this interpretation; see recognizer).
				replacement = BooleanValueWrapperNode.of(childLeaf.wrapsTrue());
				break;
			case LESS_THAN_OR_EQUAL_TO:
				// #[<=n]True reduces to True.
				// #[<=n]False reduces True.
				replacement = BooleanValueWrapperNode.trueWrapper();
				break;
			case GREATER_THAN_OR_EQUAL_TO:
			case EQUALS:
				// #[>=n]False reduces to n == 0.
				// #[=n]False reduces to n == 0.
				// #[>=n]True reduces to True (in this interpretation; see recognizer).
				// #[=n]True reduces to True (in this interpretation; see recognizer).
				if (childLeaf.wrapsFalse()) {
					replacement = BooleanValueWrapperNode.of(
							BigInteger.ZERO.equals(boundValue)
					);
				} else {
					replacement = BooleanValueWrapperNode.trueWrapper();
				}
				break;
		}

		if (replacement != null) {
			expression.replaceDescendant(parentNode, replacement);
			remainingLeaves.addFirst(replacement);
		}
	}
}
