package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsInternalExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.internal.IExpressionVisitor;

import java.util.List;

public class AssignmentWrapper<
		WrappedType extends AbsInternalExpression & IHasAssignmentCounterpart
	> extends AbsInternalExpression
{
	public static final String ID_SUFFIX = "Assignment";

	private WrappedType operatorExpression;

	public static <
		WrappedType extends AbsInternalExpression & IHasAssignmentCounterpart
	> AssignmentWrapper<WrappedType> getAssignmentCounterpart(WrappedType operation) {
		return new AssignmentWrapper<>(operation);
	}

	private AssignmentWrapper(WrappedType operatorExpression) {
		super(operatorExpression.getId() + ID_SUFFIX, operatorExpression.childCount);
		this.operatorExpression = operatorExpression;
	}

	@Override
	protected int getLocalHash() {
		return operatorExpression.getLocalHash();
	}

	@Override
	protected boolean isSubtreeHashValid() {
		return operatorExpression.isSubtreeHashValid();
	}

	@Override
	protected void setSubtreeHashValid(boolean subtreeHashValid) {
		operatorExpression.setSubtreeHashValid(subtreeHashValid);
	}

	@Override
	protected void invalidateSubtreeHash() {
		operatorExpression.invalidateSubtreeHash();
	}

	@Override
	public List<AbsExpression> getChildExpressions() {
		return operatorExpression.getChildExpressions();
	}

	@Override
	public AbsExpression getParentExpression() {
		return operatorExpression.getParentExpression();
	}

	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitAssignmentWrapper(this);
	}

	public WrappedType getOperatorExpression() {
		return operatorExpression;
	}
}
