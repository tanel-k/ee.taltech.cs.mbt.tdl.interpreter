package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.TrapsetSymbolNode;

public class AbsTrapsetOperatorNode extends AbsOperatorNode<TrapsetSymbolNode> {
	public AbsTrapsetOperatorNode(int arity) {
		super(arity);
	}
}
