package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.bound;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;

import java.math.BigInteger;

public class BoundNode extends AbsExpressionNode {
	private EBoundType boundType;
	private BigInteger boundArgument;

	public EBoundType getBoundType() {
		return boundType;
	}

	public void setBoundType(EBoundType boundType) {
		this.boundType = boundType;
	}

	public BigInteger getBoundArgument() {
		return boundArgument;
	}

	public void setBoundArgument(BigInteger boundArgument) {
		this.boundArgument = boundArgument;
	}
}
