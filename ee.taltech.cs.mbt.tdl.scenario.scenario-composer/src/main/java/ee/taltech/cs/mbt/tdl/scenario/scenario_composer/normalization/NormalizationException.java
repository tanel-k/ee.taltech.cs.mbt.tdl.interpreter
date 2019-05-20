package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.normalization;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;

public class NormalizationException extends Exception {
	private TdlExpression expression;
	private AbsBooleanInternalNode sourceNode;

	public NormalizationException(String message, TdlExpression expression) {
		this(message, null, expression);
	}

	public NormalizationException(String message, AbsBooleanInternalNode sourceNode, TdlExpression expression) {
		super(message);
		this.sourceNode = sourceNode;
		this.expression = expression;
	}

	public TdlExpression getExpression() {
		return expression;
	}

	public AbsBooleanInternalNode getSourceNode() {
		return sourceNode;
	}
}

