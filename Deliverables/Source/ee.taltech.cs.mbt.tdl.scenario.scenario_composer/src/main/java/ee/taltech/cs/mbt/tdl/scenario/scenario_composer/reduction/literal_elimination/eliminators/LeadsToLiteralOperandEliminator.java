package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

import java.util.Deque;

public class LeadsToLiteralOperandEliminator extends AbsLiteralEliminator<LeadsToNode> {
	public static LeadsToLiteralOperandEliminator getInstance(
			TdlExpression expression,
			LeadsToNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		return new LeadsToLiteralOperandEliminator(expression, parentNode, childLeaf, remainingLeaves);
	}

	private LeadsToLiteralOperandEliminator(
			TdlExpression expression,
			LeadsToNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		super(expression, parentNode, childLeaf, remainingLeaves);
	}

	@Override
	protected void eliminate(
			TdlExpression expression,
			LeadsToNode parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		AbsBooleanInternalNode rightChild = parentNode.getChildContainer().getRightChild();
		AbsBooleanInternalNode leftChild = parentNode.getChildContainer().getLeftChild();
		boolean rightChildIsBoolValue = rightChild == childLeaf;

		if (childLeaf.wrapsTrue()) {
			if (rightChildIsBoolValue) { // p ~> True ==> True.
				BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.trueWrapper();
				expression.replaceDescendant(parentNode, replacementNode);
				remainingLeaves.addFirst(replacementNode);
			} else { // True ~> p ==> p.
				expression.replaceDescendant(parentNode, rightChild);
			}
		} else {
			if (rightChildIsBoolValue) { // p ~> False ==> not(p).
				expression.replaceDescendant(parentNode, leftChild);
				leftChild.setNegated(true);
				// Get rid of the new negation:
				renormalizeSubtree(expression, leftChild, remainingLeaves);
			} else { // False ~> p ==> True.
				BooleanValueWrapperNode replacementNode = BooleanValueWrapperNode.trueWrapper();
				expression.replaceDescendant(parentNode, replacementNode);
				remainingLeaves.addFirst(replacementNode);
			}
		}
	}
}
