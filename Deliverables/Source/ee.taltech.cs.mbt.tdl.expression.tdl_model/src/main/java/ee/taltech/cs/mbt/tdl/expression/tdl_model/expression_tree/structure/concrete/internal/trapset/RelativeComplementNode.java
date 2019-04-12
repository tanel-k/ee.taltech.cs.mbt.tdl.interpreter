package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.TrapsetSymbolNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.BinaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetOperatorVisitor;

public class RelativeComplementNode extends AbsTrapsetOperatorNode<
			BinaryOperandContainer<TrapsetSymbolNode>
		> {
	public RelativeComplementNode() {
		super(new BinaryOperandContainer<>());
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitRelativeComplement(this);
	}

	@Override
	public <T> T accept(ITrapsetOperatorVisitor<T> visitor) {
		return visitor.visitRelativeComplement(this);
	}
}
