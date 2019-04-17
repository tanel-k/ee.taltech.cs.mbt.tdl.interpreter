package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentity;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.RecognizerParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory.ScenarioWrapperConstructionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class ScenarioSystemComposer {
	public static ScenarioSystemComposer newInstance(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		return new ScenarioSystemComposer(baseSystem, parameters);
	}

	private UtaSystem baseSystem;
	private ScenarioWrapperFactory wrapperFactory;

	public ScenarioSystemComposer(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		this.baseSystem = baseSystem;
		this.wrapperFactory = ScenarioWrapperFactory.getInstance(parameters);
	}

	public void compose() {
		UtaSystem wrapperSystem = wrapperFactory.newSystem();
		ScenarioWrapperConstructionContext wrapperContext = wrapperFactory.getConstructionContext();
		ObjectIdentityMap<AbsBooleanInternalNode, RecognizerParameters> recognizerParams = wrapperContext.mapRecognizerParams;
		// TODO: modify transitions in baseSystem.
		baseSystem.merge(wrapperSystem);
	}
}
