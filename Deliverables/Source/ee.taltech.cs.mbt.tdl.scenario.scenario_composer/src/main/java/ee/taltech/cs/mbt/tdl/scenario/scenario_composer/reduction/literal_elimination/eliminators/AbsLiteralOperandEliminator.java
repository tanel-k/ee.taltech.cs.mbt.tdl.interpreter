package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination.eliminators;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.Normalizer;

import java.util.Deque;

public abstract class AbsLiteralOperandEliminator<T extends AbsBooleanInternalNode> {
	private BooleanFlag completionFlag = BooleanFlag.newInstance();

	private T parentNode;
	protected TdlExpression expression;
	protected BooleanValueWrapperNode childLeaf;
	protected Deque<BooleanValueWrapperNode> remainingLeaves;

	protected AbsLiteralOperandEliminator(
			TdlExpression expression,
			T parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		this.expression = expression;
		this.parentNode = parentNode;
		this.childLeaf = childLeaf;
		this.remainingLeaves = remainingLeaves;
	}

	public void eliminate() {
		if (completionFlag.isSet())
			return;
		eliminate(expression, parentNode, childLeaf, remainingLeaves);
		completionFlag.set();
	}

	protected abstract void eliminate(
			TdlExpression expression,
			T parentNode,
			BooleanValueWrapperNode childLeaf,
			Deque<BooleanValueWrapperNode> remainingLeaves
	);

	protected void renormalizeSubtree(
			TdlExpression expression,
			AbsBooleanInternalNode subtreeRoot,
			Deque<BooleanValueWrapperNode> remainingLeaves
	) {
		Deque<BooleanValueWrapperNode> newLeaves = Normalizer
				.getInstance(expression, subtreeRoot)
				.normalize();
		// Reprocess the subtree starting form its Boolean leaves:
		while (!newLeaves.isEmpty()) {
			remainingLeaves.addFirst(newLeaves.pollLast());
		}
	}
}
