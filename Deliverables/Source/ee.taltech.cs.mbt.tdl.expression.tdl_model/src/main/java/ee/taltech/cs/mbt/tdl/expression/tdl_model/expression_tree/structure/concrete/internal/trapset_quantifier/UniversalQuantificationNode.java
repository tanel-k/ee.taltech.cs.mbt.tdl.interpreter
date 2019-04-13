package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class UniversalQuantificationNode extends AbsTrapsetQuantifierNode {
	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitUniversalQuantification(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitUniversalQuantification(this);
	}

	@Override
	public <T> T accept(ITrapsetQuantifierVisitor<T> visitor) {
		return visitor.visitUniversal(this);
	}

	@Override
	public UniversalQuantificationNode deepClone() {
		UniversalQuantificationNode clone = new UniversalQuantificationNode();
		clone.setNegated(isNegated());
		clone.getOperandContainer().setOperand(getOperandContainer().getOperand().deepClone());
		return clone;
	}
}
