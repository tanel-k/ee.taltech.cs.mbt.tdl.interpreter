package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class TrapsetSymbolNode extends AbsExpressionNode {
	private String trapsetSymbol;

	public String getTrapsetSymbol() {
		return trapsetSymbol;
	}

	public void setTrapsetSymbol(String trapsetSymbol) {
		this.trapsetSymbol = trapsetSymbol;
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitTrapsetSymbolNode(this);
	}
}
