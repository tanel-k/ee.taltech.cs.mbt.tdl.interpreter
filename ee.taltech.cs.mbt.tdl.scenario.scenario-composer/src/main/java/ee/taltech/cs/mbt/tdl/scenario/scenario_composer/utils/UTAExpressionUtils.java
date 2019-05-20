package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.utils;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.TernaryExpression;

public class UTAExpressionUtils {
	public static AbsExpression ternary(AbsExpression condition, AbsExpression ifTrue, AbsExpression ifFalse) {
		return new TernaryExpression()
				.setLeftChild(condition)
				.setMiddleChild(ifTrue)
				.setRightChild(ifFalse);
	}

	public static AbsExpression negateCondition(AbsExpression expr) {
		return new NegationExpression().setChild(wrapInGroup(expr));
	}

	public static AbsExpression wrapInGroup(AbsExpression expr) {
		return new GroupedExpression().setChild(expr);
	}
}
