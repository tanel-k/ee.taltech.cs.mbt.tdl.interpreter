package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.arity.IBinaryOperator;
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
