package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.NegationExpression;

public class EvalUtils {
	public static AbsExpression negateCondition(AbsExpression expr) {
		return new NegationExpression().setChild(
				new GroupedExpression().setChild(expr)
		);
	}
}
