package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.AbsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.ITrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;

public class BaseTrapset extends AbsTrapset<BaseTrap> {
	public BaseTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitBase(this);
	}
}
