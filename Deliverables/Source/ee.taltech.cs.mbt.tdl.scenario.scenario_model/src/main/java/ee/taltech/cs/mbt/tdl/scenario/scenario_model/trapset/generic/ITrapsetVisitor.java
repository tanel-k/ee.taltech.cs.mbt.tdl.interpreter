package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.RelativeComplementTrapset;

public interface ITrapsetVisitor<T> {
	T visitBase(BaseTrapset trapset);
	T visitAbsoluteComplement(AbsoluteComplementTrapset trapset);
	T visitLinkedPair(LinkedPairTrapset trapset);
	T visitRelativeComplement(RelativeComplementTrapset trapset);
}
