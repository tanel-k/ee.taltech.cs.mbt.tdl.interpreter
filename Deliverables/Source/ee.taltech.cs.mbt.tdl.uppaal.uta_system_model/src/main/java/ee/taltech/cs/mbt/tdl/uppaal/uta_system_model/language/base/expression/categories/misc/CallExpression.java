package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.internal.IExpressionVisitor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CallExpression extends AbsUnaryExpression {
	private List<AbsExpression> argumentList;

	public CallExpression() {
		this.argumentList = new LinkedList<>();
	}

	public List<AbsExpression> getArgumentList() {
		return Collections.unmodifiableList(argumentList);
	}

	public void addArgument(AbsExpression argumentExpression) {
		this.argumentList.add(argumentExpression);
		invalidateSubtreeHash();
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitCall(this);
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getArgumentList());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof CallExpression))
				return false;
			CallExpression other = (CallExpression) obj;
			return Objects.equals(other.argumentList, this.argumentList);
		}
		return false;
	}
}
