package ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.traversal.IExpressionTreeVisitor;

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
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitBoundedLeadsToNode(this);
	}
}
