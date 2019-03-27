package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;

public class VariableBasedTypeIdCtx extends AbsTypeIdentifierCtx {
	private IdentifierNameCtx identifierName;

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public <T> T accept(ITypeIdCtxVisitor<T> visitor) {
		return visitor.visitVariableBasedTypeId(this);
	}
}
