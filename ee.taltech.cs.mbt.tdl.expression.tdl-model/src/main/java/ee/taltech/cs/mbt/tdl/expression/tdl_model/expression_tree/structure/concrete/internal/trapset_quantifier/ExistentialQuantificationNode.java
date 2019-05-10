package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;

public class ExistentialQuantificationNode extends AbsTrapsetQuantifierNode {
	@Override
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitExistentialQuantification(this);
	}

	@Override
	public <T> T accept(IBooleanNodeVisitor<T> visitor) {
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
		clone.getChildContainer().setChild(getChildContainer().getChild().deepClone());
		return clone;
	}

	@Override
	public String getHumanReadableName() {
		return "Trapset Existential Quantification";
	}
}
