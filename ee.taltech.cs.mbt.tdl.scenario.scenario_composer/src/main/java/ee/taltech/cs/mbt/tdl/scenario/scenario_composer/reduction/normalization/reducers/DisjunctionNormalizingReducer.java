package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class DisjunctionNormalizingReducer extends AbsReducer<DisjunctionNode> {
	public static DisjunctionNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final DisjunctionNormalizingReducer INSTANCE = new DisjunctionNormalizingReducer();

	private DisjunctionNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, DisjunctionNode disjunction) {
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
