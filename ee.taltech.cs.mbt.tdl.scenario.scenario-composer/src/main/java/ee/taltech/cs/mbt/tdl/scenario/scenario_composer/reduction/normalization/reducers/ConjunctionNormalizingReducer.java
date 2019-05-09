package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class ConjunctionNormalizingReducer extends AbsReducer<ConjunctionNode> {
	public static ConjunctionNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final ConjunctionNormalizingReducer INSTANCE = new ConjunctionNormalizingReducer();

	private ConjunctionNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, ConjunctionNode conjunction) {
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
