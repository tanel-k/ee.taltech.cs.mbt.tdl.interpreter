package ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_model.nodes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SExpressionSequenceNode extends AbsSExpressionNode {
	private List<AbsSExpressionNode> children = new LinkedList<>();

	public List<AbsSExpressionNode> getChildren() {
		return children;
	}

	public SExpressionSequenceNode addChild(AbsSExpressionNode child) {
		children.add(child);
		child.setParent(this);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder("(");
		for (AbsSExpressionNode child : children)
			buf.append(child.toString());
		return buf.append(")").toString();
	}

	@Override
	public <T> T accept(ISExpressionVisitor<T> visitor) {
		return visitor.visitSequence(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof SExpressionSequenceNode))
			return false;
		SExpressionSequenceNode other = (SExpressionSequenceNode) obj;
		return Objects.equals(other.children, this.children);
	}
}