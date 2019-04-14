package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;

import java.util.Objects;

public class BoundedRepetitionNode extends AbsBooleanInternalNode<
		AbsBooleanInternalNode,
		UnaryChildContainer<AbsBooleanInternalNode>
		> implements IBounded {
	private Bound bound;

	public BoundedRepetitionNode() {
		super(new UnaryChildContainer<>(), null);
	}

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
		return visitor.visitBoundedRepetition(this);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitBoundedRepetition(this);
	}

	@Override
	public BoundedRepetitionNode deepClone() {
		BoundedRepetitionNode clone = new BoundedRepetitionNode();
		clone.setBound(getBound().deepClone());
		clone.setNegated(isNegated());
		clone.getChildContainer().setChild(getChildContainer().getChild().deepClone());
		return clone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.bound);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return this.getBound().equals(((BoundedRepetitionNode) obj).getBound());
		}

		return false;
	}
}
