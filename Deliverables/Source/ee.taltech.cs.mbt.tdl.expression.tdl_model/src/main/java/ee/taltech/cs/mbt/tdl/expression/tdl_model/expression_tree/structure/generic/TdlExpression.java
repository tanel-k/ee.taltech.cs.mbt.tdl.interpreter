package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

public class TdlExpression {
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
}
