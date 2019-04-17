package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.derived;

import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.ITrapsetVisitor;

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
