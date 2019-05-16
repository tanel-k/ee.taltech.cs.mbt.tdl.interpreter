package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.AbsoluteComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.LinkedPairsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.RelativeComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.WrappedTrapsetEvaluation;

public interface IEvaluatedTrapsetVisitor<T> {
	T visitAbsoluteComplement(AbsoluteComplementTrapsetEvaluation trapset);
	T visitLinkedPairs(LinkedPairsTrapsetEvaluation trapset);
	T visitRelativeComplement(RelativeComplementTrapsetEvaluation trapset);
	T visitWrapped(WrappedTrapsetEvaluation trapset);
}
