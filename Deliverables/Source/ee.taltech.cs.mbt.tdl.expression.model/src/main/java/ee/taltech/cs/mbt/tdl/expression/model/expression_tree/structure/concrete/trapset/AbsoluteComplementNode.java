package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.arity.IUnaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class AbsoluteComplementNode
	extends AbsTrapsetOperatorNode
	implements IUnaryOperator<TrapsetSymbolNode>
{
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitAbsoluteComplementNode(this);
	}
}
