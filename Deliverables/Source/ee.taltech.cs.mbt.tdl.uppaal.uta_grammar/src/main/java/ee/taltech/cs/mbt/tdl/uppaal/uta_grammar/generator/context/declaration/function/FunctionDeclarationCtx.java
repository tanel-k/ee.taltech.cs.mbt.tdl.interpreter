package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.AbsDeclarationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.IDeclarationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.parameter.ParameterCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement.AbsStatementCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

import java.util.LinkedList;
import java.util.List;

public class FunctionDeclarationCtx extends AbsDeclarationCtx {
	private TypeCtx valueType;
	private IdentifierNameCtx identifierName;
	private List<ParameterCtx> parameters = new LinkedList<>();
	private List<AbsDeclarationCtx> declarations = new LinkedList<>();
	private List<AbsStatementCtx> statements = new LinkedList<>();

	public TypeCtx getValueType() {
		return valueType;
	}

	public void setValueType(TypeCtx valueType) {
		this.valueType = valueType;
	}

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	public List<ParameterCtx> getParameters() {
		return parameters;
	}

	public List<AbsDeclarationCtx> getDeclarations() {
		return declarations;
	}

	public List<AbsStatementCtx> getStatements() {
		return statements;
	}

	@Override
	public <T> T accept(IDeclarationCtxVisitor<T> visitor) {
		return visitor.visitFunctionDeclaration(this);
	}
}
