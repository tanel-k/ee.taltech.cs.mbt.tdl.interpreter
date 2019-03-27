package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.IHasPhraseCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;

public class ImplicationExpression extends AbsBinaryExprNode implements IHasPhraseCounterpart {
	private boolean phrase;

	@Override
	public boolean isPhrase() {
		return phrase;
	}

	@Override
	public void setPhrase(boolean phrase) {
		this.phrase = phrase;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitImplicationExpr(this);
	}
}
