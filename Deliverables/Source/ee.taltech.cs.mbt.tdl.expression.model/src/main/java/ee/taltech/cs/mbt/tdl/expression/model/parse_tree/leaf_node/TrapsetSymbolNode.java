package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;

public class TrapsetSymbolNode extends AbsExpressionNode {
	private String trapsetSymbol;

	public String getTrapsetSymbol() {
		return trapsetSymbol;
	}

	public void setTrapsetSymbol(String trapsetSymbol) {
		this.trapsetSymbol = trapsetSymbol;
	}
}
