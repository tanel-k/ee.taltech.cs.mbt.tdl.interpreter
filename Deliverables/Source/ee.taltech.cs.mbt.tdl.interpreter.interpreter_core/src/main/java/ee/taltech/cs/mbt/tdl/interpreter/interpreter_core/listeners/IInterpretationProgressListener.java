package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core.listeners;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioCompositionResults;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public interface IInterpretationProgressListener {
	void afterExpressionParsed(TdlExpression expression);
	void afterModelParsed(UtaSystem model);
	void afterScenarioComposition(ScenarioSpecification parameters, ScenarioCompositionResults results);
	void afterFullReduction(TdlExpression tdlExpression);
	void afterScenarioSerialized();
}
