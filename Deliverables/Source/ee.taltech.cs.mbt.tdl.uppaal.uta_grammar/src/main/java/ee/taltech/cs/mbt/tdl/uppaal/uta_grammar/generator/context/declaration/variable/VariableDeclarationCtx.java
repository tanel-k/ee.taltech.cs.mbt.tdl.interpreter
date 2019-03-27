package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.AbsDeclarationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.IDeclarationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

import java.util.LinkedList;
import java.util.List;

public class VariableDeclarationCtx extends AbsDeclarationCtx {
	private TypeCtx type;
	private List<VariableInitializationCtx> variableInitializations = new LinkedList<>();

	public TypeCtx getType() {
		return type;
	}

	public void setType(TypeCtx type) {
		this.type = type;
	}

	public List<VariableInitializationCtx> getVariableInitializations() {
		return variableInitializations;
	}

	@Override
	public <T> T accept(IDeclarationCtxVisitor<T> visitor) {
		return visitor.visitVariableDeclaration(this);
	}
}
