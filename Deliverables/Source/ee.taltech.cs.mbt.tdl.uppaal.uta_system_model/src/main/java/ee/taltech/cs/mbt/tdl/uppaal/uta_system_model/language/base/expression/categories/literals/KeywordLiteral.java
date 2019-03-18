package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.internal.IExpressionVisitor;

public class KeywordLiteral extends AbsLiteralExpression<String> {
	KeywordLiteral(String keyword) {
		super(keyword);
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitKeyword(this);
	}
}