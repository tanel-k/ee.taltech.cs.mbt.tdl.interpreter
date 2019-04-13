package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsExpressionLeafNode;

import java.util.Objects;

public class TrapsetNode extends AbsExpressionLeafNode<String> {
	public static String normalizeTrapsetSymbol(String symbol) {
		return symbol.toUpperCase();
	}

	public static TrapsetNode of(String symbol) {
		return new TrapsetNode(normalizeTrapsetSymbol(symbol));
	}

	private TrapsetNode(String symbol) {
		super(symbol);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitTrapsetSymbol(this);
	}

	@Override
	public TrapsetNode deepClone() {
		return this;
	}

	@Override
	public String toString() {
		return getRepresentation();
	}

	@Override
	public int hashCode() {
		return getRepresentation().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof TrapsetNode))
			return false;
		TrapsetNode other = (TrapsetNode) obj;
		return Objects.equals(this.getRepresentation(), other.getRepresentation());
	}
}
