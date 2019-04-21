package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Optional;

public class ScenarioCompositionResults {
	public static ScenarioCompositionResults of(TdlExpression tdlExpression) {
		return new ScenarioCompositionResults(tdlExpression, null);
	}

	public static ScenarioCompositionResults of(TdlExpression tdlExpression, UtaSystem scenarioSystem) {
		return new ScenarioCompositionResults(tdlExpression, scenarioSystem);
	}

	private TdlExpression tdlExpression;
	private UtaSystem scenarioSystem;

	private ScenarioCompositionResults(TdlExpression tdlExpression, UtaSystem scenarioSystem) {
		this.tdlExpression = tdlExpression;
		this.scenarioSystem = scenarioSystem;
	}

	public TdlExpression getTdlExpression() {
		return tdlExpression;
	}

	public Optional<UtaSystem> getScenarioSystem() {
		return Optional.ofNullable(scenarioSystem);
	}
}
