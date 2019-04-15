package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset;

import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.AbsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.ITrapsetVisitor;

public class AbsoluteComplementTrapset extends AbsTrapset<BaseTrap> {
	public AbsoluteComplementTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitAbsoluteComplement(this);
	}
}
