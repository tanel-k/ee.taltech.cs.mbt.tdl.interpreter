package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class NoOpProgressListener implements IInterpretationProgressListener {
	@Override
	public void beforeExpressionParsed() { /* Do nothing */ }

	@Override
	public void afterExpressionParsed(TdlExpression expression) { /* Do nothing */ }

	@Override
	public void beforeModelParsed() { /* Do nothing */ }

	@Override
	public void afterModelParsed(UtaSystem sutModel) { /* Do nothing */ }

	@Override
	public void beforeScenarioComposition(ScenarioSpecification specification) { /* Do nothing */ }

	@Override
	public void afterScenarioComposition(ScenarioSpecification specification, ScenarioCompositionResults results) { /* Do nothing */ }

	@Override
	public void afterFullReduction(TdlExpression tdlExpression) { /* Do nothing */ }

	@Override
	public void beforeScenarioSerialized(UtaSystem scenarioModel) { /* Do nothing */ }

	@Override
	public void afterScenarioSerialized() { /* Do nothing */ }
}
