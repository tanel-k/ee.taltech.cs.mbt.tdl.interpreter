package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class BoundedLeadsToNode extends LeadsToNode implements IBounded {
	private Bound bound;

	@Override
	public Bound getBound() {
		return bound;
	}

	@Override
	public void setBound(Bound bound) {
		this.bound = bound;
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitBoundedLeadsTo(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitBoundedLeadsTo(this);
	}

	@Override
	public BoundedLeadsToNode deepClone() {
		BoundedLeadsToNode clone = new BoundedLeadsToNode();
		clone.setBound(getBound().deepClone());
		clone.setNegated(isNegated());
		clone.getChildContainer().setLeftOperand(getChildContainer().getLeftOperand().deepClone());
		clone.getChildContainer().setRightOperand(getChildContainer().getRightOperand().deepClone());
		return clone;
	}
}
