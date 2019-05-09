package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class BoundedLeadsToNormalizingReducer extends AbsReducer<BoundedLeadsToNode> {
	public static BoundedLeadsToNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final BoundedLeadsToNormalizingReducer INSTANCE = new BoundedLeadsToNormalizingReducer();

	private BoundedLeadsToNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, BoundedLeadsToNode boundedLeadsTo) {
		// FIXME: Discussed with prof Vain - turns out this is way more complicated.
		if (!boundedLeadsTo.isNegated())
			return boundedLeadsTo;

		/*
		 * The reasoning here would be similar to that for not(~>) in LeadsToNormalizingReducer.
		 * Theoretically we could have the following reduction rules:
		 * not(a ~>(>n) b)  ==> a ~>(<=n) b or not(a ~> b)
		 * not(a ~>(<n) b)  ==> a ~>(>=n) b or not(a ~> b)
		 * not(a ~>(>=n) b) ==> a ~>(<n) b or not(a ~> b)
		 * not(a ~>(<=n) b) ==> a ~>(>n) b or not(a ~> b)
		 * not(a ~>(=n) b)  ==> (a ~>(<n) b or a ~>(>n) b) or not(a ~> b)
		 * However, since not(~>) isn't implementable, we need to throw an Exception here as well.
		 * TODO!
		 */
		throw new UnsupportedOperationException("Placeholder,FIXME.");
	}
}
