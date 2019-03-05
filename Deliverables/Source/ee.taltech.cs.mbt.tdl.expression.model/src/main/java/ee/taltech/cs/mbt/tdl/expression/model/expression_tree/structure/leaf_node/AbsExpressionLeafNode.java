package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.AbsExpressionNode;

public abstract class AbsExpressionLeafNode<SymbolType> extends AbsExpressionNode {
	private SymbolType symbol;

	public SymbolType getSymbol() {
		return symbol;
	}

	public void setSymbol(SymbolType symbol) {
		this.symbol = symbol;
	}
}
