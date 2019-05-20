package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization.normalizers.AbsNormalizer;

public class EquivalenceNormalizer extends AbsNormalizer<EquivalenceNode> {
	public static EquivalenceNormalizer getInstance() {
		return INSTANCE;
	}

	private static final EquivalenceNormalizer INSTANCE = new EquivalenceNormalizer();

	private EquivalenceNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, EquivalenceNode equivalence) {
		// X <-> Y normalizes to X -> && Y -> X.
		ImplicationNode implyLeftToRight = new ImplicationNode();

		implyLeftToRight.getChildContainer()
				.setLeftChild(equivalence.getChildContainer().getLeftChild().deepClone())
				.setRightChild(equivalence.getChildContainer().getRightChild().deepClone());

		ImplicationNode implyRightToLeft = new ImplicationNode();
		implyRightToLeft.getChildContainer()
				.setLeftChild(equivalence.getChildContainer().getRightChild().deepClone())
				.setRightChild(equivalence.getChildContainer().getLeftChild().deepClone());

		ConjunctionNode conjunction = new ConjunctionNode();
		conjunction.setNegated(equivalence.isNegated());
		conjunction.getChildContainer()
				.setLeftChild(implyLeftToRight)
				.setRightChild(implyRightToLeft);

		expression.replaceDescendant(equivalence, conjunction);

		return ConjunctionNormalizer.getInstance()
				.normalize(expression, conjunction);
	}
}
