package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.leaf.AbsExpressionLeafNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class TrapsetSymbolNode extends AbsExpressionLeafNode<String> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitTrapsetSymbolNode(this);
	}

	public TrapsetSymbolNode(String symbol) {
		super(symbol);
	}
}
