package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

public abstract class AbsReducer<T extends AbsBooleanInternalNode> {
	public abstract AbsBooleanInternalNode reduce(TdlExpression expression, T node);
}
