package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.normalizers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

public class ConjunctionNormalizer extends AbsNormalizer<ConjunctionNode> {
	public static ConjunctionNormalizer getInstance() {
		return INSTANCE;
	}

	private static final ConjunctionNormalizer INSTANCE = new ConjunctionNormalizer();

	private ConjunctionNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, ConjunctionNode conjunction) {
		// not(X && Y) normalizes to not(X) || not(Y).
		if (!conjunction.isNegated())
			return conjunction;

		DisjunctionNode disjunction = new DisjunctionNode();
		expression.replaceDescendant(conjunction, disjunction);

		AbsBooleanInternalNode leftChild = conjunction.getChildContainer().getLeftChild();
		AbsBooleanInternalNode rightChild = conjunction.getChildContainer().getRightChild();

		leftChild.setNegated(!leftChild.isNegated());
		rightChild.setNegated(!rightChild.isNegated());

		disjunction.getChildContainer()
				.setLeftChild(leftChild)
				.setRightChild(rightChild);

		return disjunction;
	}
}
