package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.LiteralEliminationException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.LiteralEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.ExpressionNormalizer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.NormalizationException;

import java.util.Deque;

public class TdlExpressionNormalizingReducer {
	public static TdlExpressionNormalizingReducer getInstance(TdlExpression expression) {
		return new TdlExpressionNormalizingReducer(expression);
	}

	private Flag completionFlag = Flag.newInstance();
	private TdlExpression expression;

	private TdlExpressionNormalizingReducer(TdlExpression expression) {
		this.expression = expression;
	}

	public void normalizeAndReduce() throws NormalizationException, LiteralEliminationException {
		if (completionFlag.isSet())
			return;

		// Two sequential encapsulated sub-ops:
		// 1. Push negation to leaves (i.e. trapset quantifiers);
		// 2. Explode operators for which there is no recognizer implementation.
		ExpressionNormalizer normalizer = ExpressionNormalizer.getInstance(expression);
		Deque<BooleanValueWrapperNode> booleanLeaves = normalizer.normalize();

		// Pull remaining Boolean literals as far up the tree as possible, consuming redundant subtrees.
		LiteralEliminator eliminator = LiteralEliminator.getInstance(expression, booleanLeaves);
		eliminator.eliminate();

		completionFlag.set();
	}
}
