package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;

public class LeadsToNode extends AbsBooleanInternalNode<
		AbsBooleanInternalNode,
				BinaryChildContainer<AbsBooleanInternalNode>
		> {
	public LeadsToNode() {
		super(new BinaryChildContainer<>(), false);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitLeadsTo(this);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitLeadsTo(this);
	}

	@Override
	public LeadsToNode deepClone() {
		LeadsToNode clone = new LeadsToNode();
		clone.setNegated(isNegated());
		clone.getChildContainer().setLeftChild(getChildContainer().getLeftChild().deepClone());
		clone.getChildContainer().setRightChild(getChildContainer().getRightChild().deepClone());
		return clone;
	}
}
