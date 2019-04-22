package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class NoOpProgressListener implements IInterpretationProgressListener {
	@Override
	public void afterExpressionParsed(TdlExpression expression) { /* Do nothing */ }

	@Override
	public void afterModelParsed(UtaSystem model) { /* Do nothing */ }

	@Override
	public void afterScenarioComposition(ScenarioSpecification parameters, ScenarioCompositionResults results) { /* Do nothing */ }

	@Override
	public void afterFullReduction(TdlExpression tdlExpression) { /* Do nothing */ }

	@Override
	public void afterScenarioSerialized() { /* Do nothing */ }
}
