package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes;

public class SExprStringNode extends AbsSExprNode {
	private String string;

	public String getString() {
		return string;
	}

	public SExprStringNode setString(String string) {
		this.string = string;
		return this;
	}
}
