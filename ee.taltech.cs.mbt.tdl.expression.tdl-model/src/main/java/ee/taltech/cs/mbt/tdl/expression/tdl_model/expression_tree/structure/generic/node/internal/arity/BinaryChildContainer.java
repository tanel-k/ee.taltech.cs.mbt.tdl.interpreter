package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;

public class BinaryChildContainer<ChildType extends AbsExpressionNode> extends ChildContainer<ChildType> {
	public BinaryChildContainer() {
		super(ARITY_BINARY);
	}

	public ChildType getLeftChild() {
		return getChildNode(ORDINAL_FIRST);
	}

	public BinaryChildContainer<ChildType> setLeftChild(ChildType operand) {
		setChildNode(ORDINAL_FIRST, operand);
		return this;
	}

	public ChildType getRightChild() {
		return super.getChildNode(ORDINAL_SECOND);
	}

	public BinaryChildContainer<ChildType> setRightChild(ChildType operand) {
		setChildNode(ORDINAL_SECOND, operand);
		return this;
	}
}
