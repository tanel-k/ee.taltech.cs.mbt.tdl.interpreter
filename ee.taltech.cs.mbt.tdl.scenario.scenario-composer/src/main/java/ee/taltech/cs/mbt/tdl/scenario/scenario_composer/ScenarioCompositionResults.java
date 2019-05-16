package ee.taltech.cs.mbt.tdl.scenario.scenario_composer;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

import java.util.Optional;

public class ScenarioCompositionResults {
	public static ScenarioCompositionResults ofTrivialExpression(TdlExpression trivialExpression) {
		return new ScenarioCompositionResults(trivialExpression, null);
	}

	public static ScenarioCompositionResults of(TdlExpression tdlExpression, UtaSystem scenarioSystem) {
		return new ScenarioCompositionResults(tdlExpression, scenarioSystem);
	}

	private final TdlExpression expression;
	private final UtaSystem scenarioSystem;

	private ScenarioCompositionResults(TdlExpression expression, UtaSystem scenarioSystem) {
		this.expression = expression;
		this.scenarioSystem = scenarioSystem;
	}

	public TdlExpression getExpression() {
		return expression;
	}

	public Optional<UtaSystem> getScenarioSystem() {
		return Optional.ofNullable(scenarioSystem);
	}
}
