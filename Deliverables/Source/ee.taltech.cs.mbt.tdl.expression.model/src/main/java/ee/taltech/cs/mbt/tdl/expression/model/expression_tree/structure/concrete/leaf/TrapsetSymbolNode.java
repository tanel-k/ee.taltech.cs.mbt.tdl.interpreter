package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.leaf.AbsExpressionLeafNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IVisitableNode;

public class TrapsetSymbolNode extends AbsExpressionLeafNode<String> implements IVisitableNode {
	public TrapsetSymbolNode(String symbol) {
		super(symbol);
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitTrapsetSymbolNode(this);
	}
}
