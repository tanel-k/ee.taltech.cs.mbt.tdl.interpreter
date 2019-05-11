package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.literal_elimination;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

public class LiteralEliminationException extends Exception {
	private TdlExpression expression;
	private AbsBooleanInternalNode parentNode;
	private BooleanValueWrapperNode childLeaf;

	public LiteralEliminationException(String message, TdlExpression expression, AbsBooleanInternalNode parentNode, BooleanValueWrapperNode childLeaf) {
		super(message);
		this.expression = expression;
		this.parentNode = parentNode;
		this.childLeaf = childLeaf;
	}

	public TdlExpression getExpression() {
		return expression;
	}

	public AbsBooleanInternalNode getParentNode() {
		return parentNode;
	}

	public BooleanValueWrapperNode getChildLeaf() {
		return childLeaf;
	}
}
