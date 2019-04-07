package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.leaf.AbsExpressionLeafNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpressionVisitor;

import java.util.Objects;

public class TrapsetSymbolNode extends AbsExpressionLeafNode<String> {
	public TrapsetSymbolNode(String symbol) {
		super(symbol);
	}

	@Override
	public <T> T accept(TdlExpressionVisitor<T> visitor) {
		return visitor.visitTrapsetSymbol(this);
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
