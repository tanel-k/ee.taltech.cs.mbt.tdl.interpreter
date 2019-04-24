package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

import java.util.Objects;

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
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitBoundedLeadsTo(this);
	}

	@Override
	public BoundedLeadsToNode deepClone() {
		BoundedLeadsToNode clone = new BoundedLeadsToNode();
		clone.setBound(getBound().deepClone());
		clone.setNegated(isNegated());
		clone.getChildContainer().setLeftChild(getChildContainer().getLeftChild().deepClone());
		clone.getChildContainer().setRightChild(getChildContainer().getRightChild().deepClone());
		return clone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.bound);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return this.getBound().equals(((BoundedLeadsToNode) obj).getBound());
		}

		return false;
	}
}
