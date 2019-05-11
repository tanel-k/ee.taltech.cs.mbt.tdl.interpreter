package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.BinaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class ImplicationNode extends AbsBooleanInternalNode<
		AbsBooleanInternalNode,
				BinaryChildContainer<AbsBooleanInternalNode>
		> {
	public ImplicationNode() {
		super(new BinaryChildContainer<>(), false);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitImplication(this);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitImplication(this);
	}

	@Override
	public ImplicationNode deepClone() {
		ImplicationNode clone = new ImplicationNode();
		clone.setNegated(isNegated());
		clone.getChildContainer().setLeftChild(getChildContainer().getLeftChild().deepClone());
		clone.getChildContainer().setRightChild(getChildContainer().getRightChild().deepClone());
		return clone;
	}

	@Override
	public String getHumanReadableName() {
		return "Implication";
	}
}
