package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;

import java.util.Objects;

public class SExpression {
	private SExpressionSequenceNode root;

	public SExpressionSequenceNode getRoot() {
		return root;
	}

	public SExpression setRoot(SExpressionSequenceNode root) {
		this.root = root;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof SExpression))
			return false;
		SExpression other = (SExpression) obj;
		return Objects.equals(this.root, other.root);
	}
}
