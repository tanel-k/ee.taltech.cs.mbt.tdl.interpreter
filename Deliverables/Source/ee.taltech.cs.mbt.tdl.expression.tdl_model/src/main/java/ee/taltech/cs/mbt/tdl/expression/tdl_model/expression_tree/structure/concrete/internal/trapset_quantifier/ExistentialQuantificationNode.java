package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class ExistentialQuantificationNode extends AbsTrapsetQuantifierNode {
	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitExistentialQuantification(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitExistentialQuantification(this);
	}

	@Override
	public <T> T accept(ITrapsetQuantifierVisitor<T> visitor) {
		return visitor.visitExistential(this);
	}

	@Override
	public ExistentialQuantificationNode deepClone() {
		ExistentialQuantificationNode clone = new ExistentialQuantificationNode();
		clone.setNegated(isNegated());
		clone.getChildContainer().setOperand(getChildContainer().getOperand().deepClone());
		return clone;
	}
}
