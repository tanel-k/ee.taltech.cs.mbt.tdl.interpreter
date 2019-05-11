package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model;

import ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes.SExprSequenceNode;

public class SExpression {
	private SExprSequenceNode root;

	public SExprSequenceNode getRoot() {
		return root;
	}

	public SExpression setRoot(SExprSequenceNode root) {
		this.root = root;
		return this;
	}
}
