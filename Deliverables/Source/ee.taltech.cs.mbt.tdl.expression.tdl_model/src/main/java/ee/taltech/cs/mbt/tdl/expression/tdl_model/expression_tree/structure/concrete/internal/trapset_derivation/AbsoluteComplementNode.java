package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;

public class AbsoluteComplementNode extends AbsDerivedTrapsetNode<
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
	public <T> T accept(IDerivedTrapsetVisitor<T> visitor) {
		return visitor.visitAbsoluteComplement(this);
	}

	@Override
	public AbsoluteComplementNode deepClone() {
		AbsoluteComplementNode clone = new AbsoluteComplementNode();
		clone.getChildContainer().setChild(getChildContainer().getChild());
		return clone;
	}
}
