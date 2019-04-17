package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset;

import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.ITrapsetVisitor;

public class BaseTrapset extends AbsTrapset<BaseTrap> {
	public BaseTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitBase(this);
	}
}
