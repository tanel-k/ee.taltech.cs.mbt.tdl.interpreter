package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_model;

import java.util.LinkedList;

public class SExpressionNode {
	private SExpressionNode parent;
	private String symbol;
	private final LinkedList<SExpressionNode> children = new LinkedList<>();

	public SExpressionNode() { }

	public SExpressionNode(String symbol) {
		this.symbol = symbol;
	}

	public SExpressionNode getParent() {
		return parent;
	}

	public void setParent(SExpressionNode parent) {
		this.parent = parent;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public LinkedList<SExpressionNode> getChildren() {
		return children;
	}
}
