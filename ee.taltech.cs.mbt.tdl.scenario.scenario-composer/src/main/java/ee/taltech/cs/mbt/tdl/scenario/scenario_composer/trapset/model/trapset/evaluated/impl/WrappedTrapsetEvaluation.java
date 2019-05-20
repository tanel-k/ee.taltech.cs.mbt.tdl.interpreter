package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.ITrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.IEvaluatedTrapsetVisitor;

public class WrappedTrapsetEvaluation extends AbsTrapsetEvaluation<BaseTrap> {
	public WrappedTrapsetEvaluation() { }

	@Override
	public <T> T accept(IEvaluatedTrapsetVisitor<T> visitor) {
		return visitor.visitWrapped(this);
	}

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitWrapped(this);
	}
}
