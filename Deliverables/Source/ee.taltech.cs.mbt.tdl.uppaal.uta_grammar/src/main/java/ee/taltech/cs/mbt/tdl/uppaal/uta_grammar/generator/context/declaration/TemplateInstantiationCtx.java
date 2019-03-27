package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.parameter.ParameterCtx;

import java.util.LinkedList;
import java.util.List;

public class TemplateInstantiationCtx extends AbsDeclarationCtx {
	private IdentifierNameCtx newName;
	private IdentifierNameCtx originalName;
	private List<ParameterCtx> parameters = new LinkedList<>();
	private List<AbsExpressionCtx> arguments = new LinkedList<>();

	public IdentifierNameCtx getNewName() {
		return newName;
	}

	public void setNewName(IdentifierNameCtx newName) {
		this.newName = newName;
	}

	public IdentifierNameCtx getOriginalName() {
		return originalName;
	}

	public void setOriginalName(IdentifierNameCtx originalName) {
		this.originalName = originalName;
	}

	public List<ParameterCtx> getParameters() {
		return parameters;
	}

	public List<AbsExpressionCtx> getArguments() {
		return arguments;
	}

	@Override
	public <T> T accept(IDeclarationCtxVisitor<T> visitor) {
		return visitor.visitTemplateInstantiation(this);
	}
}
