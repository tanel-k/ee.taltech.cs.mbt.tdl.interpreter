package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BoundedLeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.DisjunctionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.LeadsToNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.EBoundType;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class BoundedLeadsToNormalizingReducer extends AbsReducer<BoundedLeadsToNode> {
	public static BoundedLeadsToNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final BoundedLeadsToNormalizingReducer INSTANCE = new BoundedLeadsToNormalizingReducer();

	private BoundedLeadsToNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, BoundedLeadsToNode boundedLeadsTo) {
		if (!boundedLeadsTo.isNegated())
			return boundedLeadsTo;

		/*
		 * not(a ~>(>n) b)  ==> a ~>(<=n) b or not(a ~> b)
		 * not(a ~>(<n) b)  ==> a ~>(>=n) b or not(a ~> b)
		 * not(a ~>(>=n) b) ==> a ~>(<n) b or not(a ~> b)
		 * not(a ~>(<=n) b) ==> a ~>(>n) b or not(a ~> b)
		 * not(a ~>(=n) b)  ==> (a ~>(<n) b or a ~>(>n) b) or not(a ~> b)
		 */
		AbsBooleanInternalNode leftChild = boundedLeadsTo.getChildContainer().getLeftChild();
		AbsBooleanInternalNode rightChild = boundedLeadsTo.getChildContainer().getRightChild();

		DisjunctionNode disjunction = new DisjunctionNode();
		LeadsToNode negatedLeadsTo = new LeadsToNode();
		negatedLeadsTo.setNegated(true);
		negatedLeadsTo.getChildContainer().setLeftChild(leftChild.deepClone());
		negatedLeadsTo.getChildContainer().setRightChild(rightChild.deepClone());

		disjunction.getChildContainer().setLeftChild(boundedLeadsTo);
		disjunction.getChildContainer().setRightChild(negatedLeadsTo);

		Bound bound = boundedLeadsTo.getBound();
		switch (bound.getBoundType()) {
			case GREATER_THAN:
				expression.replaceDescendant(boundedLeadsTo, disjunction);
				bound.setBoundType(EBoundType.LESS_THAN_OR_EQUAL_TO);
				break;
			case LESS_THAN:
				expression.replaceDescendant(boundedLeadsTo, disjunction);
				bound.setBoundType(EBoundType.GREATER_THAN_OR_EQUAL_TO);
				break;
			case GREATER_THAN_OR_EQUAL_TO:
				expression.replaceDescendant(boundedLeadsTo, disjunction);
				bound.setBoundType(EBoundType.LESS_THAN);
				break;
			case LESS_THAN_OR_EQUAL_TO:
				expression.replaceDescendant(boundedLeadsTo, disjunction);
				bound.setBoundType(EBoundType.GREATER_THAN);
				break;
			case EQUALS:
				expression.replaceDescendant(boundedLeadsTo, disjunction);
				bound.setBoundType(EBoundType.GREATER_THAN);
				BoundedLeadsToNode boundedLeadsToClone = boundedLeadsTo.deepClone();
				boundedLeadsToClone.getBound().setBoundType(EBoundType.LESS_THAN);
				DisjunctionNode boundDisjunction = new DisjunctionNode();
				boundDisjunction.getChildContainer().setLeftChild(boundedLeadsToClone);
				boundDisjunction.getChildContainer().setRightChild(boundedLeadsTo);
				disjunction.getChildContainer().setLeftChild(boundDisjunction);
				disjunction.getChildContainer().setRightChild(negatedLeadsTo);
				break;
		}

		return disjunction;
	}
}
