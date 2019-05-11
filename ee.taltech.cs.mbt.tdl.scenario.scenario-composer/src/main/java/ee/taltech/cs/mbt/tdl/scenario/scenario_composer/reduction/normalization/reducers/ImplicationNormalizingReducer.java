package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

public class ImplicationNormalizingReducer extends AbsNormalizingReducer<ImplicationNode> {
	public static ImplicationNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final ImplicationNormalizingReducer INSTANCE = new ImplicationNormalizingReducer();

	private ImplicationNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, ImplicationNode implication) {
		// X -> Y reduces to not(X) || Y.
		DisjunctionNode disjunction = new DisjunctionNode();
		expression.replaceDescendant(implication, disjunction);

		AbsBooleanInternalNode leftChild = implication.getChildContainer().getLeftChild();
		AbsBooleanInternalNode rightChild = implication.getChildContainer().getRightChild();
		leftChild.setNegated(!leftChild.isNegated());

		disjunction.setNegated(implication.isNegated());
		disjunction.getChildContainer().setLeftChild(leftChild);
		disjunction.getChildContainer().setRightChild(rightChild);

		return DisjunctionNormalizingReducer.getInstance()
				.reduce(expression, disjunction);
	}
}
