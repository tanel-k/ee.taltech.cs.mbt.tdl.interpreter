package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity.IBinaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

public class RelativeComplementNode extends AbsTrapsetOperatorNode<BinaryOperandContainer<TrapsetSymbolNode>> {
	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitRelativeComplementNode(this);
	}

	public RelativeComplementNode() {
		super(new BinaryOperandContainer<>());
	}
}
