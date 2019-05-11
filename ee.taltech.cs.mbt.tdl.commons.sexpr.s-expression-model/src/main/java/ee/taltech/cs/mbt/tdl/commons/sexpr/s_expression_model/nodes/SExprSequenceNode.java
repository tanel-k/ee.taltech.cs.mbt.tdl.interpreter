package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model.nodes;

import java.util.LinkedList;
import java.util.List;

public class SExprSequenceNode extends AbsSExprNode {
	private List<AbsSExprNode> children = new LinkedList<>();

	public List<AbsSExprNode> getChildren() {
		return children;
	}
}
