package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.modifier;

import java.math.BigInteger;

public class Bound {
	private EBoundType boundType;
	private BigInteger boundValue;

	public EBoundType getBoundType() {
		return boundType;
	}

	public void setBoundType(EBoundType boundType) {
		this.boundType = boundType;
	}

	public BigInteger getBoundValue() {
		return boundValue;
	}

	public void setBoundValue(BigInteger boundValue) {
		this.boundValue = boundValue;
	}
}
