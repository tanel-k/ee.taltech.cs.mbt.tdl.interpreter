package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.derived.RelativeComplementTrapset;

public interface ITrapsetVisitor<T> {
	T visitBase(BaseTrapset trapset);
	T visitAbsoluteComplement(AbsoluteComplementTrapset trapset);
	T visitLinkedPair(LinkedPairTrapset trapset);
	T visitRelativeComplement(RelativeComplementTrapset trapset);
}
