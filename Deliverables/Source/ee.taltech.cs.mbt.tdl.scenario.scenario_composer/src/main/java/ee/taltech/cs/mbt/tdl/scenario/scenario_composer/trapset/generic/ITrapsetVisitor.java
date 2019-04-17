package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.derived.RelativeComplementTrapset;

public interface ITrapsetVisitor<T> {
	T visitBase(BaseTrapset trapset);
	T visitAbsoluteComplement(AbsoluteComplementTrapset trapset);
	T visitLinkedPair(LinkedPairTrapset trapset);
	T visitRelativeComplement(RelativeComplementTrapset trapset);
}
