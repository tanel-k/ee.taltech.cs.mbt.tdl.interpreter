package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ConjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.EquivalenceNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.ImplicationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class EquivalenceNormalizingReducer extends AbsReducer<EquivalenceNode> {
	public static EquivalenceNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final EquivalenceNormalizingReducer INSTANCE = new EquivalenceNormalizingReducer();

	private EquivalenceNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, EquivalenceNode equivalence) {
		ImplicationNode implyLeftToRight = new ImplicationNode();
		implyLeftToRight.getChildContainer()
				.setLeftChild(equivalence.getChildContainer().getLeftChild())
				.setRightChild(equivalence.getChildContainer().getRightChild());

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
		return ConjunctionNormalizingReducer.getInstance()
				.reduce(expression, conjunction);
	}
}
