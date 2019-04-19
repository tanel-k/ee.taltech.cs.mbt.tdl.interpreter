package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.ITrapsetVisitor;

public class AbsoluteComplementTrapset extends AbsDerivedTrapset<BaseTrap> {
	public AbsoluteComplementTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitAbsoluteComplement(this);
	}

	@Override
	public <T> T accept(IDerivedTrapsetVisitor<T> visitor) {
		return visitor.visitAbsoluteComplement(this);
	}
}
