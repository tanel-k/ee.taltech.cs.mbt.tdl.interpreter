package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.trapset;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.leaf.TrapsetSymbolNode;

public abstract class AbsTrapsetOperatorNode extends AbsOperatorNode<TrapsetSymbolNode> {
	public AbsTrapsetOperatorNode(int arity) {
		super(arity);
	}
}
