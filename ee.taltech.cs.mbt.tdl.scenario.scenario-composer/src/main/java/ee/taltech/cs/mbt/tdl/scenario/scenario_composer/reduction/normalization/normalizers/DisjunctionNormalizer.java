package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.normalizers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

public class DisjunctionNormalizer extends AbsNormalizer<DisjunctionNode> {
	public static DisjunctionNormalizer getInstance() {
		return INSTANCE;
	}

	private static final DisjunctionNormalizer INSTANCE = new DisjunctionNormalizer();

	private DisjunctionNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, DisjunctionNode disjunction) {
		// not(X || Y) normalizes to not(X) && not(Y).
		if (!disjunction.isNegated())
			return disjunction;

		ConjunctionNode conjunction = new ConjunctionNode();
		expression.replaceDescendant(disjunction, conjunction);

		AbsBooleanInternalNode leftChild = disjunction.getChildContainer().getLeftChild();
		AbsBooleanInternalNode rightChild = disjunction.getChildContainer().getRightChild();
		leftChild.setNegated(!leftChild.isNegated());
		rightChild.setNegated(!rightChild.isNegated());

		conjunction.getChildContainer()
				.setLeftChild(leftChild)
				.setRightChild(rightChild);

		return conjunction;
	}
}
