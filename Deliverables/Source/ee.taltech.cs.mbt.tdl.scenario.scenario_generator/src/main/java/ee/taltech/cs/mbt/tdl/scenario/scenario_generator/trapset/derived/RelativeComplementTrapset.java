package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.derived;

import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.ITrapsetVisitor;

public class RelativeComplementTrapset extends AbsDerivedTrapset<BaseTrap> {
	public RelativeComplementTrapset() { }

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitRelativeComplement(this);
	}

	@Override
	public <T> T accept(IDerivedTrapsetVisitor<T> visitor) {
		return visitor.visitRelativeComplement(this);
	}
}
