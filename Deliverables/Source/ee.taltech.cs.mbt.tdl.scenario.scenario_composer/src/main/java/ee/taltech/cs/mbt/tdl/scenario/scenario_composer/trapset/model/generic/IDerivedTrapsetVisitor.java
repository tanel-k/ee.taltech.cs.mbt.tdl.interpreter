package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.RelativeComplementTrapset;

public interface IDerivedTrapsetVisitor<T> {
	T visitAbsoluteComplement(AbsoluteComplementTrapset trapset);
	T visitLinkedPair(LinkedPairTrapset trapset);
	T visitRelativeComplement(RelativeComplementTrapset trapset);
}
