package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.derived.RelativeComplementTrapset;

public interface IDerivedTrapsetVisitor<T> {
	T visitAbsoluteComplement(AbsoluteComplementTrapset trapset);
	T visitLinkedPair(LinkedPairTrapset trapset);
	T visitRelativeComplement(RelativeComplementTrapset trapset);
}
