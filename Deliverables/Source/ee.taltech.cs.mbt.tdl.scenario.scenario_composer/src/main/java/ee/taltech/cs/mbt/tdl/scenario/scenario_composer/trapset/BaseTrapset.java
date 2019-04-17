package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.ITrapsetVisitor;

public class BaseTrapset extends AbsTrapset<BaseTrap> {
	public BaseTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitBase(this);
	}
}
