package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.LiteralEliminator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.ExpressionNormalizer;

import java.util.Deque;

public class TdlExpressionReducer {
	public static TdlExpressionReducer getInstance(TdlExpression expression) {
		return new TdlExpressionReducer(expression);
	}

	private BooleanFlag completionFlag = BooleanFlag.newInstance();
	private TdlExpression expression;

	private TdlExpressionReducer(TdlExpression expression) {
		this.expression = expression;
	}

	public void reduce() {
		if (completionFlag.isSet())
			return;

		ExpressionNormalizer normalizer = ExpressionNormalizer.getInstance(expression);
		Deque<BooleanValueWrapperNode> booleanLeaves = normalizer.normalize();

		LiteralEliminator eliminator = LiteralEliminator.getInstance(expression, booleanLeaves);
		eliminator.eliminate();

		completionFlag.set();
	}
}
