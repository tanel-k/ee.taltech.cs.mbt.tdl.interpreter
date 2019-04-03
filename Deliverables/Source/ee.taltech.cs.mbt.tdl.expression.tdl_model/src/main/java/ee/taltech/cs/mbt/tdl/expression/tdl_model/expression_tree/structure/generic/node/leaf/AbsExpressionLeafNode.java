package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

public abstract class AbsExpressionLeafNode<SymbolType> extends AbsExpressionNode {
	private SymbolType symbol;

	protected AbsExpressionLeafNode(SymbolType symbol) {
		this.symbol = symbol;
	}

	public SymbolType getSymbol() {
		return symbol;
	}

	public void setSymbol(SymbolType symbol) {
		this.symbol = symbol;
	}
}
