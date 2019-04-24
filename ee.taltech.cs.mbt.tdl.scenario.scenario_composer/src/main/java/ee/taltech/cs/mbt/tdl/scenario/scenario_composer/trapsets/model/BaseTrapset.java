package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.ITrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.trap.BaseTrap;

public class BaseTrapset extends AbsTrapset<BaseTrap> {
	public BaseTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitBase(this);
	}
}
