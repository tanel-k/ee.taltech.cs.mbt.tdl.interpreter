package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an expression in UPPAAL syntax.<br/>
 * Here we represent expressions as tree structures in which each node extends this class.<br/>
 * In UPPAAL, assignments are also treated as expressions.<br/>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ID
 *             |  NAT
 *             |  Expression '[' Expression ']'
 *             |  '(' Expression ')'
 *             |  Expression '++' | '++' Expression
 *             |  Expression '--' | '--' Expression
 *             |  Expression Assign Expression
 *             |  Unary Expression
 *             |  Expression Binary Expression
 *             |  Expression '?' Expression ':' Expression
 *             |  Expression '.' ID
 *             |  Expression '(' Arguments ')'
 *             |  'forall' '(' ID ':' Type ')' Expression
 *             |  'exists' '(' ID ':' Type ')' Expression
 *             |  'deadlock' | 'true' | 'false'
 * Arguments  ::= [ Expression ( ',' Expression )* ]
 * Assign     ::= '=' | ':=' | '+=' | '-=' | '*=' | '/=' | '%='
 *             | '|=' | '&amp;=' | '^=' | '&lt;&lt;=' | '&gt;&gt;='
 * Unary      ::= '+' | '-' | '!' | 'not'
 * Binary     ::= '&lt;' | '&lt;=' | '==' | '!=' | '&gt;=' | '&gt;'
 *             |  '+' | '-' | '*' | '/' | '%' | '&'
 *             |  '|' | '^' | '&lt;&lt;' | '&gt;&gt;' | '&&' | '||'
 *             |  '&lt;?' | '&gt;?' | 'or' | 'and' | 'imply'
 * </pre>
 */
public abstract class AbsExpression implements IDeepCloneable<AbsExpression> {
	private AbsExpression parentExpression;
	private final List<AbsExpression> childExpressions;
	protected final int childCount;

	protected AbsExpression(int childCount) {
		if (childCount < 0)
			throw new IllegalArgumentException("An expression may not have less than 0 children.");
		this.childCount = childCount;
		this.childExpressions = new ArrayList<>(Collections.nCopies(this.childCount, null));
	}

	protected AbsExpression setChildExpression(int position, AbsExpression childExpression) {
		if (position < 0 || position >= childCount)
			throw new IllegalArgumentException(
				"Child expression position " + position + " out of bounds."
			);

		AbsExpression previousChild;
		if ((previousChild = this.childExpressions.get(position)) != null) {
			previousChild.setParentExpression(null);
		}

		this.childExpressions.set(position, childExpression);
		if (childExpression != null)
			childExpression.setParentExpression(this);

		return this;
	}

	protected AbsExpression getChildExpression(int position) {
		if (position < 0 || position >= childCount)
			throw new IllegalArgumentException("Child expression position " + position + " out of bounds.");
		return this.childExpressions.get(position);
	}

	public AbsExpression getParentExpression() {
		return parentExpression;
	}

	public AbsExpression setParentExpression(AbsExpression parentExpression) {
		this.parentExpression = parentExpression;
		return this;
	}

	protected List<AbsExpression> getChildExpressions() {
		return Collections.unmodifiableList(childExpressions);
	}

	public abstract <T> T accept(IExpressionVisitor<T> visitor);

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getClass().getSimpleName())
			.append("(");
		for (AbsExpression child : getChildExpressions()) {
			sb.append(child).append(",");
		}
		return sb.append(")").toString();
	}
}
