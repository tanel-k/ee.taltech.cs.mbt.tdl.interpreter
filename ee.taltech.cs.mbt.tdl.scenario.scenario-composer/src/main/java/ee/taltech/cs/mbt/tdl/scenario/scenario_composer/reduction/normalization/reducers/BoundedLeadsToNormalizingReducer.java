package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.NormalizationException;

public class BoundedLeadsToNormalizingReducer extends AbsNormalizingReducer<BoundedLeadsToNode> {
	public static BoundedLeadsToNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final BoundedLeadsToNormalizingReducer INSTANCE = new BoundedLeadsToNormalizingReducer();

	private BoundedLeadsToNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, BoundedLeadsToNode boundedLeadsTo) throws NormalizationException {
		if (!boundedLeadsTo.isNegated())
			return boundedLeadsTo;

		/*
		 * The reasoning here would be similar to the one we have for not(~>) in LeadsToNormalizingReducer.
		 * Theoretically we could have the following reduction rules:
		 * - not(a ~>(>n) b)  reduces to a ~>(<=n) b or not(a ~> b);
		 * - not(a ~>(<n) b)  reduces to a ~>(>=n) b or not(a ~> b);
		 * - not(a ~>(>=n) b) reduces to a ~>(<n) b or not(a ~> b);
		 * - not(a ~>(<=n) b) reduces to a ~>(>n) b or not(a ~> b);
		 * - not(a ~>(=n) b)  reduces to (a ~>(<n) b or a ~>(>n) b) or not(a ~> b).
		 * However, since not(~>) isn't implementable, we need to throw an Exception here as well.
		 */
		throw new NormalizationException("Negation of bounded leads to is not supported.", boundedLeadsTo, expression);
	}
}
