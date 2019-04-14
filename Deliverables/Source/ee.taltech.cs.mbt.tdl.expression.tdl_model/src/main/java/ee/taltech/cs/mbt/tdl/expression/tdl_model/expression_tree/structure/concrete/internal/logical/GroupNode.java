package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;

public class GroupNode extends AbsBooleanInternalNode<
		AbsBooleanInternalNode,
		UnaryChildContainer<AbsBooleanInternalNode>
		> {
	public GroupNode() {
		super(new UnaryChildContainer<>(), null);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitGroup(this);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitGroup(this);
	}

	@Override
	public GroupNode deepClone() {
		GroupNode clone = new GroupNode();
		clone.setNegated(isNegated());
		clone.getChildContainer().setChild(getChildContainer().getChild().deepClone());
		return clone;
	}
}
