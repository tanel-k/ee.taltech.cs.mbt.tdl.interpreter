package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.ITrapsetVisitor;

public class BaseTrapset extends AbsTrapset<BaseTrap> {
	public BaseTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitBase(this);
	}
}
