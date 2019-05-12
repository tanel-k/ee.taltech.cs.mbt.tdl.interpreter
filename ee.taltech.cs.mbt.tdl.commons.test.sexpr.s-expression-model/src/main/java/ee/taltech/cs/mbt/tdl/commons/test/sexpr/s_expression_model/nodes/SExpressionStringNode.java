package ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof SExpressionStringNode))
			return false;
		SExpressionStringNode other = (SExpressionStringNode) obj;
		return Objects.equals(other.string, this.string);
	}
}
