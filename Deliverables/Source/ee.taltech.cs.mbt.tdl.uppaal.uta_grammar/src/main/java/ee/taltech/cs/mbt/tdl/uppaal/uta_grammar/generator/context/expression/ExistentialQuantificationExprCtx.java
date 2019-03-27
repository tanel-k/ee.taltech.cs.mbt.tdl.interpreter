package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsUnaryExprCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

public class ExistentialQuantificationExprCtx extends AbsUnaryExprCtx {
	private IdentifierNameCtx identifierName;
	private TypeCtx type;

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	public TypeCtx getType() {
		return type;
	}

	public void setType(TypeCtx type) {
		this.type = type;
	}

	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitExistentialQuantificationExpr(this);
	}
}
