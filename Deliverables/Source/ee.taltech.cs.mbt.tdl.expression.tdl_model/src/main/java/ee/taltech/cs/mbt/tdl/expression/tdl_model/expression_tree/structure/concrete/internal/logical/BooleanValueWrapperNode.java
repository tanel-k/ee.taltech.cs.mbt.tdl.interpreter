package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.AbsBooleanLeafNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.FalseNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical.TrueNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.arity.UnaryChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class BooleanValueWrapperNode extends AbsBooleanInternalNode<AbsBooleanLeafNode, UnaryChildContainer<AbsBooleanLeafNode>> {
	public static BooleanValueWrapperNode trueWrapper() {
		return wrap(TrueNode.getInstance());
	}

	public static BooleanValueWrapperNode falseWrapper() {
		return wrap(FalseNode.getInstance());
	}

	public static BooleanValueWrapperNode wrap(AbsBooleanLeafNode leafNode) {
		BooleanValueWrapperNode inst = new BooleanValueWrapperNode();
		inst.getChildContainer().setChild(leafNode);
		return inst;
	}

	protected BooleanValueWrapperNode() {
		super(new UnaryChildContainer<>(), null);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
		return visitor.visitValueWrapper(this);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitBooleanValueWrapper(this);
	}

	public boolean isTrue() {
		return getChildContainer().getChild() == TrueNode.getInstance();
	}

	@Override
	public boolean isNegated() {
		return false;
	}

	@Override
	public void setNegated(boolean negated) {
		// Flip the value we are wrapping now:
		getChildContainer().setChild(isTrue()
				? FalseNode.getInstance()
				: TrueNode.getInstance()
		);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + getChildContainer().getChild() + ")";
	}

	@Override
	public AbsBooleanInternalNode<AbsBooleanLeafNode, UnaryChildContainer<AbsBooleanLeafNode>> deepClone() {
		BooleanValueWrapperNode clone = new BooleanValueWrapperNode();
		clone.getChildContainer().setChild(getChildContainer().getChild());
		return clone;
	}
}
