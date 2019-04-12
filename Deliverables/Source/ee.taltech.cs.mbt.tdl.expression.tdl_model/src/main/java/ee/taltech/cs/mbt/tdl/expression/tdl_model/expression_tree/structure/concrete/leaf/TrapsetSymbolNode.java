package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsExpressionLeafNode;

import java.util.Objects;

public class TrapsetSymbolNode extends AbsExpressionLeafNode<String> {
	public static String normalizeTrapsetSymbol(String symbol) {
		return symbol.toUpperCase();
	}

	public static TrapsetSymbolNode of(String symbol) {
		return new TrapsetSymbolNode(normalizeTrapsetSymbol(symbol));
	}

	private TrapsetSymbolNode(String symbol) {
		super(symbol);
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitTrapsetSymbol(this);
	}

	@Override
	public String toString() {
		return getSymbol();
	}

	@Override
	public int hashCode() {
		return getSymbol().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof TrapsetSymbolNode))
			return false;
		TrapsetSymbolNode other = (TrapsetSymbolNode) obj;
		return Objects.equals(this.getSymbol(), other.getSymbol());
	}
}
