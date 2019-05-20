package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.NormalizationException;

public abstract class AbsNormalizer<T extends AbsBooleanInternalNode> {
	public abstract AbsBooleanInternalNode normalize(TdlExpression expression, T node) throws NormalizationException;
}
