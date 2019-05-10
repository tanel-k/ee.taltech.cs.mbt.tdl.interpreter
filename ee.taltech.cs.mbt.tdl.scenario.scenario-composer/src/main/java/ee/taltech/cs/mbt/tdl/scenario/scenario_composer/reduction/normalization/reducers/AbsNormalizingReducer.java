package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.NormalizationException;

public abstract class AbsNormalizingReducer<T extends AbsBooleanInternalNode>
		extends AbsReducer<T, NormalizationException> {
	// Marker class.
}
