package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public abstract class AbsExpressionNode implements IDeepCloneable<AbsExpressionNode> {
	private AbsExpressionNode parentNode;

	public int getHeight() {
		return 0;
	}

	public AbsExpressionNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(AbsExpressionNode parentNode) {
		this.parentNode = parentNode;
	}

	public abstract <T> T accept(ITdlExpressionVisitor<T> visitor);

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object object);
}
