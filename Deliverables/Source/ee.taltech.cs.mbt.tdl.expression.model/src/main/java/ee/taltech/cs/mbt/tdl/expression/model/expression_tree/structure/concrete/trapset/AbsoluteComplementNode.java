package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.trapset.AbsUnaryTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class AbsoluteComplementNode extends AbsUnaryTrapsetOperatorNode {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitAbsoluteComplementNode(this);
	}
}
