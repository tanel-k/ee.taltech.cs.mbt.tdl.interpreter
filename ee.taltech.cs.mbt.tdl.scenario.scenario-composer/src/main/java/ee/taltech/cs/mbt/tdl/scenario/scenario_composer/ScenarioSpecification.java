package ee.taltech.cs.mbt.tdl.scenario.scenario_composer;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

public class ScenarioSpecification {
	public static ScenarioSpecification of(UtaSystem sutModel, TdlExpression tdlExpression) {
		return new ScenarioSpecification(sutModel, tdlExpression);
	}

	private TdlExpression expression;
	private UtaSystem systemModel;

	private ScenarioSpecification(UtaSystem systemModel, TdlExpression expression) {
		this.systemModel = systemModel;
		this.expression = expression;
	}

	public TdlExpression getTdlExpression() {
		return expression;
	}

	public UtaSystem getSutModel() {
		return systemModel;
	}
}
