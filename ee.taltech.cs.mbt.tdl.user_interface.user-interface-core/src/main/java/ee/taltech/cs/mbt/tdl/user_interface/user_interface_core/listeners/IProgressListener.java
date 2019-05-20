package ee.taltech.cs.mbt.tdl.user_interface.user_interface_core.listeners;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

public interface IProgressListener {
	void beforeExpressionParsed();
	void afterExpressionParsed(TdlExpression expression);

	void beforeModelParsed();
	void afterModelParsed(UtaSystem sutModel);

	void beforeScenarioComposition(ScenarioSpecification specification);
	void afterScenarioComposition(ScenarioSpecification specification, ScenarioCompositionResults results);
	void onFullReduction(TdlExpression tdlExpression);

	void beforeScenarioSerialized(UtaSystem scenarioModel);
	void afterScenarioSerialized();
}
