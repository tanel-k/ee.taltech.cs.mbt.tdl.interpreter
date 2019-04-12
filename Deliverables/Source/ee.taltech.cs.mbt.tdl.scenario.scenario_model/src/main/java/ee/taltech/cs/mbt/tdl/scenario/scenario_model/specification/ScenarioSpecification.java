package ee.taltech.cs.mbt.tdl.scenario.scenario_model.specification;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class ScenarioSpecification {
	public static ScenarioSpecification of(UtaSystem sutModel, TdlExpression tdlExpression) {
		return new ScenarioSpecification(sutModel, tdlExpression);
	}

	private TdlExpression tdlExpression;
	private UtaSystem sutModel;

	private ScenarioSpecification(UtaSystem sutModel, TdlExpression tdlExpression) {
		this.sutModel = sutModel;
		this.tdlExpression = tdlExpression;
	}

	public TdlExpression getTdlExpression() {
		return tdlExpression;
	}

	public UtaSystem getSutModel() {
		return sutModel;
	}
}
