package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

import java.util.Deque;

public class BoundedLeadsToLiteralOperandEliminator extends AbsLiteralOperandEliminator<BoundedLeadsToNode> {
	public static BoundedLeadsToLiteralOperandEliminator getInstance(
			TdlExpression expression,
			BoundedLeadsToNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		return new BoundedLeadsToLiteralOperandEliminator(expression, parentNode, childLeaf, remainingLeaves);
	}

	private BoundedLeadsToLiteralOperandEliminator(
			TdlExpression expression,
			BoundedLeadsToNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		super(expression, parentNode, childLeaf, remainingLeaves);
	}

	@Override
	protected void eliminate(
			TdlExpression expression,
			BoundedLeadsToNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		// FIXME: Figure it if this is legitimate.
		/*
		 * True ~> [>x] P
		 * True ~> [<x] P
		 * True ~> [>=x] P
		 * True ~> [<=x] P
		 * True ~> [=x] P
		 *
		 * False ~> [>x] P
		 * False ~> [<x] P
		 * False ~> [>=x] P
		 * False ~> [<=x] P
		 * False ~> [=x] P
		 *
		 * P ~> [>x] True
		 * P ~> [<x] True
		 * P ~> [>=x] True
		 * P ~> [<=x] True
		 * P ~> [=x] True
		 *
		 * P ~> [>x] False
		 * P ~> [<x] False
		 * P ~> [>=x] False
		 * P ~> [<=x] False
		 * P ~> [=x] False
		 */

		LeadsToLiteralOperandEliminator
				.getInstance(expression, parentNode, childLeaf, remainingLeaves)
				.eliminate();
	}
}
