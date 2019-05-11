package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_model.nodes;

import java.util.LinkedList;
import java.util.List;

public class SExpressionSequenceNode extends AbsSExpressionNode {
	private List<AbsSExpressionNode> children = new LinkedList<>();

	public List<AbsSExpressionNode> getChildren() {
		return children;
	}

	@Override
	public <T> T accept(ISExpressionVisitor<T> visitor) {
		return visitor.visitSequence(this);
	}
}
