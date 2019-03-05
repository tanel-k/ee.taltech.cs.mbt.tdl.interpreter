package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.trapset.AbsBinaryTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class RelativeComplementNode extends AbsBinaryTrapsetOperatorNode {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitRelativeComplementNode(this);
	}
}
