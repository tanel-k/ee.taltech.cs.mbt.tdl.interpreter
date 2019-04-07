package ee.taltech.cs.mbt.tdl.scenario.scenario_generator;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class ScenarioSpecification {
	private TdlExpression scenarioExpression;
	private UtaSystem systemModel;

	public ScenarioSpecification(UtaSystem systemModel, TdlExpression scenarioExpression) {
		this.systemModel = systemModel;
		this.scenarioExpression = scenarioExpression;
	}

	public TdlExpression getScenarioExpression() {
		return scenarioExpression;
	}

	public UtaSystem getSystemModel() {
		return systemModel;
	}
}
