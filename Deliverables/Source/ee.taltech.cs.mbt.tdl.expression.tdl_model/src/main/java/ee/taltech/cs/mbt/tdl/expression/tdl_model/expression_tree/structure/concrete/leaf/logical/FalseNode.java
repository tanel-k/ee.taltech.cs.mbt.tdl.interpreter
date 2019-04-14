package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsLeafNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class FalseNode extends AbsBooleanLeafNode {
	public static FalseNode getInstance() {
		return INSTANCE;
	}

	private static final FalseNode INSTANCE = new FalseNode();

	private FalseNode() { }

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitFalse(this);
	}

	@Override
	public FalseNode deepClone() {
		return this;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object object) {
		return this == object;
	}
}
