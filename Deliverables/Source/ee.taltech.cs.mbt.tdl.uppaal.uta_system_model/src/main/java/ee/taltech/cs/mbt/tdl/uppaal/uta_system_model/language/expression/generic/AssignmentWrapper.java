package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsInternalExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

import java.util.List;

/**
 * See {@link IHasAssignmentCounterpart}.<br/>
 * This class is meant to be used as a wrapper around
 * operations which have an assignment variant.<br/>
 * By using the wrapper we mark the nested expression
 * as an assignment.<br/>
 * @param <WrappedType> See {@link AbsInternalExpression}.
 */
@Deprecated
public class AssignmentWrapper<
		WrappedType extends AbsInternalExpression & IHasAssignmentCounterpart
	> extends AbsInternalExpression
{
	public static final String ID_SUFFIX = "Assignment";

	private WrappedType wrappedExpression;

	public static <
		WrappedType extends AbsInternalExpression & IHasAssignmentCounterpart
	> AssignmentWrapper<WrappedType> wrap(WrappedType operation) {
		return new AssignmentWrapper<>(operation);
	}

	private AssignmentWrapper(WrappedType wrappedExpression) {
		super(wrappedExpression.getHashSeed() + ID_SUFFIX, wrappedExpression.childCount);
		this.wrappedExpression = wrappedExpression;
	}

	@Override
	protected int getLocalHash() {
		return wrappedExpression.getLocalHash();
	}

	@Override
	protected boolean isSubtreeHashValid() {
		return wrappedExpression.isSubtreeHashValid();
	}

	@Override
	protected void setSubtreeHashValid(boolean subtreeHashValid) {
		wrappedExpression.setSubtreeHashValid(subtreeHashValid);
	}

	@Override
	protected void invalidateSubtreeHash() {
		wrappedExpression.invalidateSubtreeHash();
	}

	@Override
	protected List<AbsExpression> getChildExpressions() {
		return wrappedExpression.getChildExpressions();
	}

	@Override
	protected void setChildExpression(int position, AbsExpression childExpression) {
		wrappedExpression.setChildExpression(position, childExpression);
	}

	@Override
	public AbsExpression getChildExpression(int position) {
		return wrappedExpression.getChildExpression(position);
	}

	@Override
	public AbsExpression getParentExpression() {
		return wrappedExpression.getParentExpression();
	}

	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitAssignmentWrapper(this);
	}

	public WrappedType getWrappedExpression() {
		return wrappedExpression;
	}
}
