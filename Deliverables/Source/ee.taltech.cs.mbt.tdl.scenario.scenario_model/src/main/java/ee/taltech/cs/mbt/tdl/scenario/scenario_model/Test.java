package ee.taltech.cs.mbt.tdl.scenario.scenario_model;

import ee.taltech.cs.mbt.tdl.scenario.scenario_model.uta_stub.ScenarioStubSystemFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class Test {
	public static void main(String... args) {
		UtaSystem system = ScenarioStubSystemFactory.getInstance().newScenarioStubSystem();
	}
}
