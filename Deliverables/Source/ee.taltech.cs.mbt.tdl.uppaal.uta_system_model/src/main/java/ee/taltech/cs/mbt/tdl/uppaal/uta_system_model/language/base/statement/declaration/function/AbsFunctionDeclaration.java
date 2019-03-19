package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers.ParameterDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;

public abstract class AbsFunctionDeclaration extends AbsDeclarationStatement {
	private Identifier name;
	private ParameterDeclarationList parameters;
	private StatementBlock body;

	public Identifier getName() {
		return name;
	}

	public void setName(Identifier name) {
		this.name = name;
	}

	public ParameterDeclarationList getParameters() {
		return parameters;
	}

	public void setParameters(ParameterDeclarationList parameters) {
		this.parameters = parameters;
	}

	public StatementBlock getBody() {
		return body;
	}

	public void setBody(StatementBlock body) {
		this.body = body;
	}
}
