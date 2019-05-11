package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_model;

import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_model.nodes.SExpressionSequenceNode;

public class SExpression {
	private SExpressionSequenceNode root;

	public SExpressionSequenceNode getRoot() {
		return root;
	}

	public SExpression setRoot(SExpressionSequenceNode root) {
		this.root = root;
		return this;
	}
}
