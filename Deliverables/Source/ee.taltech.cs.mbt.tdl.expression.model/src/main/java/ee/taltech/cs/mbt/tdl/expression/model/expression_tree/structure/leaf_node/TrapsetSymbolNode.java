package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class TrapsetSymbolNode extends AbsExpressionLeafNode<String> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitTrapsetSymbolNode(this);
	}
}
