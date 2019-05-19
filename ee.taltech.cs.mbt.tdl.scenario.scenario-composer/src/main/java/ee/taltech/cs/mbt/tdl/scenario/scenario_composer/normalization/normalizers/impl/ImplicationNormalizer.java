package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.AbsNormalizer;

public class ImplicationNormalizer extends AbsNormalizer<ImplicationNode> {
	public static ImplicationNormalizer getInstance() {
		return INSTANCE;
	}

	private static final ImplicationNormalizer INSTANCE = new ImplicationNormalizer();

	private ImplicationNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, ImplicationNode implication) {
		// X -> Y reduces to not(X) || Y.
		DisjunctionNode disjunction = new DisjunctionNode();
		expression.replaceDescendant(implication, disjunction);

		AbsBooleanInternalNode leftChild = implication.getChildContainer().getLeftChild();
		AbsBooleanInternalNode rightChild = implication.getChildContainer().getRightChild();
		leftChild.setNegated(!leftChild.isNegated());

		disjunction.setNegated(implication.isNegated());
		disjunction.getChildContainer().setLeftChild(leftChild);
		disjunction.getChildContainer().setRightChild(rightChild);

		return DisjunctionNormalizer.getInstance()
				.normalize(expression, disjunction);
	}
}
