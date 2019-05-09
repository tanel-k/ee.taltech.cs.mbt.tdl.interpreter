package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.IEvaluatedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.ITrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.trap.BaseTrap;

public class WrappedTrapset extends AbsEvaluatedTrapset<BaseTrap> {
	public WrappedTrapset() { }

	@Override
	public <T> T accept(IEvaluatedTrapsetVisitor<T> visitor) {
		return visitor.visitWrapped(this);
	}

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitWrapped(this);
	}
}
