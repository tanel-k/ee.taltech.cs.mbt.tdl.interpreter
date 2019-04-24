package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

import java.math.BigInteger;

public class BoundedRepetitionNormalizingReducer extends AbsReducer<BoundedRepetitionNode> {
	public static BoundedRepetitionNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final BoundedRepetitionNormalizingReducer INSTANCE = new BoundedRepetitionNormalizingReducer();

	private BoundedRepetitionNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, BoundedRepetitionNode boundedRepetition) {
		Bound bound = boundedRepetition.getBound();
		BigInteger boundValue = bound.getBoundValue();
		BooleanValueWrapperNode replacementNode = null;

		if (boundedRepetition.isNegated()) {
			switch (bound.getBoundType()) {
				case GREATER_THAN: // not(#[>n]P) ==> True.
					replacementNode = BooleanValueWrapperNode.trueWrapper();
					break;
				case LESS_THAN: // not(#[<n]P) ==> n == 0.
					replacementNode = BooleanValueWrapperNode.of(
							BigInteger.ZERO.equals(boundValue)
					);
					break;
				case LESS_THAN_OR_EQUAL_TO: // not(#[<=]P) ==> False.
					replacementNode = BooleanValueWrapperNode.falseWrapper();
					break;
				case GREATER_THAN_OR_EQUAL_TO: // not(#[>=]P) ==> n > 0.
				case EQUALS: // not(#[=n]P) ==> n > 0.
					replacementNode = BooleanValueWrapperNode.of(
							BigInteger.ZERO.compareTo(boundValue) < 0
					);
					break;
			}
		} else {
			switch (bound.getBoundType()) {
				case LESS_THAN: // #[<n]P ==> n > 0.
					replacementNode = BooleanValueWrapperNode.of(
							BigInteger.ZERO.compareTo(boundValue) < 0
					);
					break;
				case LESS_THAN_OR_EQUAL_TO: // #[<=n]P ==> True.
					replacementNode = BooleanValueWrapperNode.trueWrapper();
					break;
				case GREATER_THAN_OR_EQUAL_TO:
				case EQUALS:
					// #[>=0]P ==> True.
					// #[=0]P ==> True.
					if (BigInteger.ZERO.equals(boundValue))
						replacementNode = BooleanValueWrapperNode.trueWrapper();
					// Otherwise we need to count.
					break;
				case GREATER_THAN: // Need to count.
					break;
			}
		}

		if (replacementNode != null) {
			expression.replaceDescendant(boundedRepetition, replacementNode);
			return replacementNode;
		}

		return boundedRepetition;
	}
}
