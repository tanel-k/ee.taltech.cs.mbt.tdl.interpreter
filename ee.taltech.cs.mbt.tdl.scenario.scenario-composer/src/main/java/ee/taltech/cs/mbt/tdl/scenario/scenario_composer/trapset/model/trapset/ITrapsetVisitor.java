package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.AbsoluteComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.LinkedPairsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.RelativeComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.WrappedTrapsetEvaluation;

public interface ITrapsetVisitor<T> {
	T visitBase(BaseTrapset trapset);
	T visitWrapped(WrappedTrapsetEvaluation trapset);
	T visitAbsoluteComplement(AbsoluteComplementTrapsetEvaluation trapset);
	T visitLinkedPairs(LinkedPairsTrapsetEvaluation trapset);
	T visitRelativeComplement(RelativeComplementTrapsetEvaluation trapset);
}
