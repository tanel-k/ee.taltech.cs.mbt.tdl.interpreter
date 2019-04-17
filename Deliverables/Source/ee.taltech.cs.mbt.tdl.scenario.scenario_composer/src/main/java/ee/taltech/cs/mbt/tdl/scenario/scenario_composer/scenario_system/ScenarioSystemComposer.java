package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory.ScenarioWrapperConstructionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class ScenarioSystemComposer {
	private UtaSystem baseSystem;
	private ScenarioSystemParameters parameters;
	private ScenarioWrapperFactory wrapperFactory;

	public ScenarioSystemComposer(UtaSystem baseSystem, ScenarioSystemParameters parameters) {
		this.parameters = parameters;
		this.baseSystem = baseSystem;
		this.wrapperFactory = ScenarioWrapperFactory.getInstance(parameters);
	}

	public void compose() {
		UtaSystem wrapperSystem = wrapperFactory.newSystem();
		ScenarioWrapperConstructionContext wrapperContext = wrapperFactory.getConstructionContext();
	}
}
