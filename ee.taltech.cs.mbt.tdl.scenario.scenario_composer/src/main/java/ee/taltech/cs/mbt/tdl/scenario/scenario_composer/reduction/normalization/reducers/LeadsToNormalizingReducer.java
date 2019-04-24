package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class LeadsToNormalizingReducer extends AbsReducer<LeadsToNode> {
	public static LeadsToNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final LeadsToNormalizingReducer INSTANCE = new LeadsToNormalizingReducer();

	private LeadsToNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, LeadsToNode leadsTo) {
		if (!leadsTo.isNegated())
			return leadsTo;

		// not(a ~> b) ==> not(a) or (a ~> not(b)).
		DisjunctionNode disjunction = new DisjunctionNode();
		expression.replaceDescendant(leadsTo, disjunction);

		AbsBooleanInternalNode leftChild = leadsTo.getChildContainer().getLeftChild();
		AbsBooleanInternalNode rightChild = leadsTo.getChildContainer().getRightChild();

		AbsBooleanInternalNode leftChildClone = leftChild.deepClone();
		leftChildClone.setNegated(!leftChild.isNegated());
		rightChild.setNegated(!rightChild.isNegated());
		leadsTo.setNegated(false);

		disjunction.getChildContainer().setLeftChild(leftChildClone);
		disjunction.getChildContainer().setRightChild(leadsTo);

		return DisjunctionNormalizingReducer.getInstance().reduce(expression, disjunction);
	}
}
