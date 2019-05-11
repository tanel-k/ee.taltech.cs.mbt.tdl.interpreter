package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsLeafNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

import java.util.Objects;

public class TrapsetNode extends AbsLeafNode {
	public static String normalizeTrapsetSymbol(String symbol) {
		return symbol.toUpperCase();
	}

	public static TrapsetNode of(String symbol) {
		return new TrapsetNode(normalizeTrapsetSymbol(symbol));
	}

	private String name;

	private TrapsetNode(String symbol) {
		this.name = symbol;
	}

	public String getName() {
		return name;
	}

	public TrapsetNode setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitTrapset(this);
	}

	@Override
	public TrapsetNode deepClone() {
		return this;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
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
		return Objects.equals(this.name, other.name);
	}

	@Override
	public String getHumanReadableName() {
		return "Trapset '" + getName() + "'";
	}
}
