package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators.AbsLiteralOperandEliminator;

import java.util.Deque;

public class ConjunctionLiteralOperandEliminator extends AbsLiteralOperandEliminator<ConjunctionNode> {
	public static ConjunctionLiteralOperandEliminator getInstance(
			TdlExpression expression,
			ConjunctionNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		return new ConjunctionLiteralOperandEliminator(expression, parentNode, childLeaf, remainingLeaves);
	}

	private ConjunctionLiteralOperandEliminator(
			TdlExpression expression,
			ConjunctionNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		super(expression, parentNode, childLeaf, remainingLeaves);
	}

	@Override
	protected void eliminate(
			TdlExpression expression,
			ConjunctionNode conjunction,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		AbsBooleanInternalNode rightChild = conjunction.getChildContainer().getRightChild();
		AbsBooleanInternalNode leftChild = conjunction.getChildContainer().getLeftChild();
		boolean rightChildIsBoolValue = rightChild == childLeaf;

		if (childLeaf.wrapsTrue()) {
			// True and X reduces to X.
			expression.replaceDescendant(conjunction, rightChildIsBoolValue ? leftChild : rightChild);
		} else {
			// False and X reduces to False.
			BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.falseWrapper();
			expression.replaceDescendant(conjunction, replacementNode);
			remainingLeaves.addFirst(replacementNode);
		}
	}
}
