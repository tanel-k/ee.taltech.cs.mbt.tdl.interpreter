package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.IHasPhraseCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

public class ImplicationExpression extends AbsBinaryExprNode implements IHasPhraseCounterpart {
	private boolean phrase;

	@Override
	public boolean isPhrase() {
		return phrase;
	}

	@Override
	public ImplicationExpression setPhrase(boolean phrase) {
		this.phrase = phrase;
		return this;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitImplicationExpr(this);
	}

	@Override
	protected ImplicationExpression topLevelClone() {
		ImplicationExpression clone = new ImplicationExpression();
		clone.setPhrase(isPhrase());
		return clone;
	}

	@Override
	public ImplicationExpression deepClone() {
		return (ImplicationExpression) super.deepClone();
	}
}
