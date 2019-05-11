package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;

public class UnaryChildContainer<ChildType extends AbsExpressionNode> extends ChildContainer<ChildType> {
	public UnaryChildContainer() {
		super(ARITY_UNARY);
	}

	public ChildType getChild() {
		return getChildNode(ORDINAL_FIRST);
	}

	public UnaryChildContainer<ChildType> setChild(ChildType operand) {
		setChildNode(ORDINAL_FIRST, operand);
		return this;
	}
}
