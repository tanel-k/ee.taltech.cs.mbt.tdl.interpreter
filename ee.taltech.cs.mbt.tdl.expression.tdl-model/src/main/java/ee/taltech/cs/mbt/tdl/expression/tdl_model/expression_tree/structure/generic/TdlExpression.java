package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.Objects;
import java.util.Optional;

public class TdlExpression implements IDeepCloneable<TdlExpression> {
	private AbsBooleanInternalNode<?, ?> rootNode;

	public AbsBooleanInternalNode<?, ?> getRootNode() {
		return rootNode;
	}

	public void setRootNode(AbsBooleanInternalNode<?, ?> rootNode) {
		this.rootNode = rootNode;
	}

	public boolean isDescendant(AbsExpressionNode node) {
		AbsExpressionNode parentNode = node;
		while (parentNode != null && parentNode.getParentNode() != null) {
			parentNode = parentNode.getParentNode();
		}
		return parentNode == rootNode;
	}

	@SuppressWarnings("unchecked")
	public void replaceDescendant(AbsBooleanInternalNode prevChild, AbsBooleanInternalNode newChild) {
		if (prevChild.getParentNode() == null) {
			if (prevChild == rootNode) {
				setRootNode(newChild);
			}
		} else {
			AbsBooleanInternalNode parent = (AbsBooleanInternalNode) prevChild.getParentNode();
			parent.getChildContainer().replaceChildNode(prevChild, newChild);
		}
		prevChild.setParentNode(null); // Detach from expression tree.
	}

	public boolean rootIsBooleanWrapper() {
		return rootNode != null
				&& rootNode instanceof BooleanValueWrapperNode;
	}

	public Optional<BooleanValueWrapperNode> getRootBooleanWrapper() {
		if (!rootIsBooleanWrapper())
			return Optional.empty();
		return Optional.of((BooleanValueWrapperNode) rootNode);
	}

	@Override
	public TdlExpression deepClone() {
		TdlExpression clone = new TdlExpression();
		clone.rootNode = rootNode != null
				? rootNode.deepClone()
				: null;
		return clone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), rootNode);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof TdlExpression))
			return false;
		TdlExpression other = (TdlExpression) obj;
		return Objects.equals(this.rootNode, other.rootNode);
	}
}
