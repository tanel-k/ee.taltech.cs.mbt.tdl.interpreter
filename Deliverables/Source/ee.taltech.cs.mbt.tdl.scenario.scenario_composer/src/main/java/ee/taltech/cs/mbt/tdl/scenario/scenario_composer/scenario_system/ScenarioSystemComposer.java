package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory.ScenarioWrapperConstructionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class ScenarioSystemComposer {
	public static ScenarioSystemComposer newInstance(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		return new ScenarioSystemComposer(baseSystem, parameters);
	}

	private UtaSystem baseSystem;
	private ScenarioCompositionParameters parameters;
	private ScenarioWrapperFactory wrapperFactory;

	public ScenarioSystemComposer(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		this.parameters = parameters;
		this.baseSystem = baseSystem;
		this.wrapperFactory = ScenarioWrapperFactory.getInstance(parameters);
	}

	public void compose() {
		UtaSystem wrapperSystem = wrapperFactory.newSystem();
		ScenarioWrapperConstructionContext wrapperContext = wrapperFactory.getConstructionContext();
		wrapperContext.getGloballyApplicableTransitionNotificationChannels();
		// TODO: modify transitions in baseSystem.
		baseSystem.merge(wrapperSystem);
	}
}
