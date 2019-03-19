package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class AbsExpression {
	public static enum Associativity { LEFT, RIGHT, NONE }

	private AbsExpression parentExpression;
	private List<AbsExpression> childExpressions;

	protected String hashSeed;
	protected int childCount;
	protected int subtreeHash;
	protected boolean isSubtreeHashValid = false;

	protected AbsExpression(int childCount) {
		this(null, childCount);
	}

	protected AbsExpression(String hashSeed, int childCount) {
		this.hashSeed = hashSeed != null
			? hashSeed
			: this.getClass().getName();
		this.childCount = childCount;
		this.childExpressions = new ArrayList<>(Collections.nCopies(this.childCount, null));
	}

	protected boolean isSubtreeHashValid() {
		return isSubtreeHashValid;
	}

	protected void setSubtreeHashValid(boolean subtreeHashValid) {
		this.isSubtreeHashValid = subtreeHashValid;
	}

	protected void invalidateSubtreeHash() {
		setSubtreeHashValid(false);
		if (getParentExpression() != null)
			getParentExpression().invalidateSubtreeHash();
	}

	protected void setChildExpression(int position, AbsExpression childExpression) {
		if (position < 0 || position >= childCount)
			throw new IllegalArgumentException("Child expression position " + position + " out of bounds.");

		AbsExpression previousChild;
		if ((previousChild = this.childExpressions.get(position)) != null) {
			previousChild.setParentExpression(null);
		}

		this.childExpressions.set(position, childExpression);
		childExpression.setParentExpression(this);
		invalidateSubtreeHash();
	}

	protected AbsExpression getChildExpression(int position) {
		if (position < 0 || position >= childCount)
			throw new IllegalArgumentException("Child expression position " + position + " out of bounds.");
		return this.childExpressions.get(position);
	}

	public int getChildCount() {
		return childCount;
	}

	public AbsExpression getParentExpression() {
		return parentExpression;
	}

	public void setParentExpression(AbsExpression parentExpression) {
		this.parentExpression = parentExpression;
	}

	public List<AbsExpression> getChildExpressions() {
		return Collections.unmodifiableList(childExpressions);
	}

	public Associativity getAssociativity() {
		return Associativity.NONE;
	}

	public abstract void accept(IExpressionVisitor visitor);

	protected int getLocalHash() {
		return Objects.hash(getHashSeed());
	}

	protected String getHashSeed() {
		return hashSeed;
	}

	@Override
	public final int hashCode() {
		if (!isSubtreeHashValid()) {
			subtreeHash = Objects.hash(getHashSeed(), getLocalHash());
			if (getChildExpressions() != null && getChildExpressions().size() > 0) {
				for (AbsExpression child : getChildExpressions()) {
					if (child != null)
						subtreeHash = (Objects.hash(subtreeHash, child.hashCode()) << 1) + 1;
				}
			}
			setSubtreeHashValid(true);
		}
		return subtreeHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbsExpression))
			return false;
		AbsExpression other = (AbsExpression) obj;
		return Objects.equals(other.hashSeed, this.hashSeed)
			&& Objects.equals(other.childExpressions, this.childExpressions);
	}
}
