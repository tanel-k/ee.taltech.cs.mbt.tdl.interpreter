package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

public class IterationStmtCtx extends AbsStatementCtx {
	private IdentifierNameCtx identifierName;
	private TypeCtx iteratedType;

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	public TypeCtx getIteratedType() {
		return iteratedType;
	}

	public void setIteratedType(TypeCtx iteratedType) {
		this.iteratedType = iteratedType;
	}

	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitIterationStatement(this);
	}
}
