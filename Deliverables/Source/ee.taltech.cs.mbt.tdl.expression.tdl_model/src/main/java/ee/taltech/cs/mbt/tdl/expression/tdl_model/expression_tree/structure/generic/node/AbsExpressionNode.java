package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public abstract class AbsExpressionNode implements IDeepCloneable<AbsExpressionNode> {
	private int depth = 0;
	private AbsExpressionNode parentNode;

	public int getDepth() {
		return depth;
	}

	public int getHeight() {
		return 0;
	}

	public AbsExpressionNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(AbsExpressionNode parentNode) {
		this.depth = parentNode != null
				? (parentNode.getDepth() + 1)
				: 0;
		this.parentNode = parentNode;
	}

	public abstract <T> T accept(ITdlExpressionVisitor<T> visitor);
}
