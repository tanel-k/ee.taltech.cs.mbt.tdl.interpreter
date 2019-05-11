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
			BoundedLeadsToNode boundedLeadsTo,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		if (childLeaf.wrapsFalse()) {
			// X ~> [Cond(x)] False reduces to False (can never achieve a state that is impossible).
			// False ~> [Cond(x)] X reduces to False (can never enter impossible starting state).
			BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.falseWrapper();
			expression.replaceDescendant(boundedLeadsTo, replacementNode);
			remainingLeaves.addFirst(replacementNode);
		}

		/*
		 * cond(x) in { f(x) = clk < x, f(x) = clk <= x, f(x) = clk > x, f(x) = clk >= x, f(x) = clk == x }.
		 *
		 * Otherwise:
		 * P ~> [cond(x)] True.
		 * True ~> [cond(x)] P.
		 *
		 * Abstraction leak:
		 * We leave the True node as-is because we know it will be replaced with TdlTrivialTrueRecognizer.
		 * The latter will help us ensure that the delay specified by the bound will be respected.
		 */
	}
}
