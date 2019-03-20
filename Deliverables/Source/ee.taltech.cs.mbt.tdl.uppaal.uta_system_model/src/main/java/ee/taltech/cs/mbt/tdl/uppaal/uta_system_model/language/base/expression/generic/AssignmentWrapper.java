package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsInternalExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

import java.util.List;

/**
 * See {@link IHasAssignmentCounterpart}.<br/>
 * This class is meant to be used as a wrapper around
 * operations which have an assignment variant.<br/>
 * By using the wrapper we mark the nested expression
 * as an assignment.<br/>
 * @param <WrappedType> See {@link AbsInternalExpression}.
 */
public class AssignmentWrapper<
		WrappedType extends AbsInternalExpression & IHasAssignmentCounterpart
	> extends AbsInternalExpression
{
	public static final String ID_SUFFIX = "Assignment";

	private WrappedType operatorExpression;

	public static <
		WrappedType extends AbsInternalExpression & IHasAssignmentCounterpart
	> AssignmentWrapper<WrappedType> wrap(WrappedType operation) {
		return new AssignmentWrapper<>(operation);
	}

	private AssignmentWrapper(WrappedType operatorExpression) {
		super(operatorExpression.getHashSeed() + ID_SUFFIX, operatorExpression.childCount);
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
	protected List<AbsExpression> getChildExpressions() {
		return operatorExpression.getChildExpressions();
	}

	@Override
	protected void setChildExpression(int position, AbsExpression childExpression) {
		operatorExpression.setChildExpression(position, childExpression);
	}

	@Override
	public AbsExpression getChildExpression(int position) {
		return operatorExpression.getChildExpression(position);
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
