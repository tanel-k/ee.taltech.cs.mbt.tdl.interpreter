package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.modifier;

import java.math.BigInteger;

public class BoundNode {
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
