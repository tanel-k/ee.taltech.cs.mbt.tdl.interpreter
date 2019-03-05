package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node.TrapsetSymbolNode;

public abstract class AbsTrapsetOperatorNode extends AbsOperatorNode<TrapsetSymbolNode> {
	public AbsTrapsetOperatorNode(int arity) {
		super(arity);
	}
}
