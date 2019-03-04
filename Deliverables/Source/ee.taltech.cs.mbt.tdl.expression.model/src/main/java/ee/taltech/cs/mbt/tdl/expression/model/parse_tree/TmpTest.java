package ee.taltech.cs.mbt.tdl.expression.model.parse_tree;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.concrete.logical.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.concrete.trapset.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.TrapsetSymbolNode;

public class TmpTest {
	public static void main(String... args) {
		ExpressionTree tree = new ExpressionTree();
		TrapsetSymbolNode symbol = new TrapsetSymbolNode();
		symbol.setTrapsetSymbol("TR1");
		AbsoluteComplementNode complement = new AbsoluteComplementNode();
		complement.setOperand(symbol);
		ExistentialQuantificationNode exQuant = new ExistentialQuantificationNode();
		exQuant.setOperand(complement);
		tree.setRootNode(exQuant);
	}
}
