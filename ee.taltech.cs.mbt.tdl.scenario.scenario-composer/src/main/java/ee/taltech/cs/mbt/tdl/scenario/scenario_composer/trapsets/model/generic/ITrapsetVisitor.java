package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated.LinkedPairsTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated.RelativeComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated.WrappedTrapset;

public interface ITrapsetVisitor<T> {
	T visitBase(BaseTrapset trapset);
	T visitWrapped(WrappedTrapset trapset);
	T visitAbsoluteComplement(AbsoluteComplementTrapset trapset);
	T visitLinkedPairs(LinkedPairsTrapset trapset);
	T visitRelativeComplement(RelativeComplementTrapset trapset);
}
