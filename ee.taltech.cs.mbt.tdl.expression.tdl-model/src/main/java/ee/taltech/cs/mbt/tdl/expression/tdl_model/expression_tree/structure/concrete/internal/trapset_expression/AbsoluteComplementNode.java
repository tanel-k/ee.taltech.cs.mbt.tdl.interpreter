package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetExpressionVisitor;

public class AbsoluteComplementNode extends AbsTrapsetExpressionNode<
		UnaryChildContainer<TrapsetNode>
		> {
	public AbsoluteComplementNode() {
		super(new UnaryChildContainer<>(), null);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitAbsoluteComplement(this);
	}

	@Override
	public <T> T accept(ITrapsetExpressionVisitor<T> visitor) {
		return visitor.visitAbsoluteComplement(this);
	}

	@Override
	public AbsoluteComplementNode deepClone() {
		AbsoluteComplementNode clone = new AbsoluteComplementNode();
		clone.getChildContainer().setChild(getChildContainer().getChild());
		return clone;
	}

	@Override
	public String toString() {
		return getHumanReadableName();
	}

	@Override
	public String getHumanReadableName() {
		return "Absolute Complement";
	}
}
