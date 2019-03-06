package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.arity.IBinaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class LeadsToNode
	extends AbsLogicalOperatorNode<AbsLogicalOperatorNode>
	implements IBinaryOperator<AbsLogicalOperatorNode>
{
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitLeadsToNode(this);
	}
}
