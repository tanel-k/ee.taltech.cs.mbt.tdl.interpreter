package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;

public class LinkedPairNode extends AbsTrapsetOperatorNode<
			BinaryOperandContainer<TrapsetSymbolNode>
		> {
	public LinkedPairNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public <T> T accept(TdlExpressionVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}
}
