package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.normalizers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedRepetitionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

import java.math.BigInteger;

public class BoundedRepetitionNormalizer extends AbsNormalizer<BoundedRepetitionNode> {
	public static BoundedRepetitionNormalizer getInstance() {
		return INSTANCE;
	}

	private static final BoundedRepetitionNormalizer INSTANCE = new BoundedRepetitionNormalizer();

	private BoundedRepetitionNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, BoundedRepetitionNode boundedRepetition) {
		Bound bound = boundedRepetition.getBound();
		BigInteger boundValue = bound.getBoundValue();
		BooleanValueWrapperNode replacementNode = null;

		if (boundedRepetition.isNegated()) {
			/* not(#[* n] P), * in { >, >=, =, <, <= }.
			 *
			 * not(#[>n]P) is #[<=n]P is True (in our interpretation).
			 * not(#[>=n]P) is #[<n]P is n > 0 (in our interpretation).
			 * not(#[<n]P) is #[>=n]P (not reducible).
			 * not(#[<=n]P) is #[>n]P (not reducible).
			 * not(#[=n]P) is (#[<n]P || #[>n]P) is n > 0 (in our interpretation).
			 */
			switch (bound.getBoundType()) {
				case LESS_THAN:
					bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
					boundedRepetition.setNegated(false);
					break;
				case LESS_THAN_OR_EQUAL_TO:
					bound.setBoundType(EBoundType.GREATER_THAN);
					boundedRepetition.setNegated(false);
					break;
				case GREATER_THAN:
					replacementNode = BooleanValueWrapperNode.trueWrapper();
					break;
				case GREATER_THAN_OR_EQUAL_TO:
				case EQUALS:
					replacementNode = BooleanValueWrapperNode.of(
							BigInteger.ZERO.compareTo(boundValue) < 0
					);
					break;
			}
		} else {
			/*
			 * #[>=0]P reduces to True.
			 * #[=0]P reduces to True.
			 * #[<n]P reduces to n > 0.
			 * #[<n]P reduces to True if n > 0.
			 * #[<=n]P reduces to True (always, as per our interpretation).
			 */
			switch (bound.getBoundType()) {
				case LESS_THAN:
					replacementNode = BooleanValueWrapperNode.of(
							BigInteger.ZERO.compareTo(boundValue) < 0
					);
					break;
				case LESS_THAN_OR_EQUAL_TO:
					replacementNode = BooleanValueWrapperNode.trueWrapper();
					break;
				case GREATER_THAN_OR_EQUAL_TO:
				case EQUALS:
					if (BigInteger.ZERO.equals(boundValue))
						replacementNode = BooleanValueWrapperNode.trueWrapper();
					break;
				case GREATER_THAN:
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
