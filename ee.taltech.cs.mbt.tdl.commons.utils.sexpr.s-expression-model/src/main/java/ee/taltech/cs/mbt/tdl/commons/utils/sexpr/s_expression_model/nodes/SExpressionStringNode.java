package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_model.nodes;

public class SExpressionStringNode extends AbsSExpressionNode {
	private String string;

	public String getString() {
		return string;
	}

	public SExpressionStringNode setString(String string) {
		this.string = string;
		return this;
	}

	@Override
	public <T> T accept(ISExpressionVisitor<T> visitor) {
		return visitor.visitString(this);
	}
}
