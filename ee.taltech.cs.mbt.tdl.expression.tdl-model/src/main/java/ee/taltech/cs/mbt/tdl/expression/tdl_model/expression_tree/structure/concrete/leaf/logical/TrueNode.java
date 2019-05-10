package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsLeafNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class TrueNode extends AbsBooleanLeafNode {
	public static TrueNode getInstance() {
		return INSTANCE;
	}

	private static final TrueNode INSTANCE = new TrueNode();

	private TrueNode() { }

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitTrue(this);
	}

	@Override
	public TrueNode deepClone() {
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

	@Override
	public String getHumanReadableName() {
		return "TRUE";
	}
}
