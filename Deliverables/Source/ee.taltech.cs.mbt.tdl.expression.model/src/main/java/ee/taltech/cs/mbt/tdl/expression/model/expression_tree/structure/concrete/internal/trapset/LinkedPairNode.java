package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity.IBinaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class LinkedPairNode
	extends AbsTrapsetOperatorNode
	implements IBinaryOperator<TrapsetSymbolNode>
{
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitLinkedPairNode(this);
	}
}
