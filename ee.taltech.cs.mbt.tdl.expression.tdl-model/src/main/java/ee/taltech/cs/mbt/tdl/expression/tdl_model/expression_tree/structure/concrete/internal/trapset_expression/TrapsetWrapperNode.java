package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetExpressionVisitor;

public class TrapsetWrapperNode extends AbsTrapsetExpressionNode<UnaryChildContainer<TrapsetNode>> {
	public TrapsetWrapperNode() {
		super(new UnaryChildContainer<>(), null);
	}

	@Override
	public TrapsetWrapperNode deepClone() {
		TrapsetWrapperNode clone = new TrapsetWrapperNode();
		clone.getChildContainer().setChild(getChildContainer().getChild().deepClone());
		return clone;
	}

	@Override
	public <T> T accept(ITrapsetExpressionVisitor<T> visitor) {
		return visitor.visitTrapsetWrapper(this);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitTrapsetWrapper(this);
	}

	@Override
	public String getHumanReadableName() {
		return getChildContainer().getChild().getHumanReadableName();
	}
}
