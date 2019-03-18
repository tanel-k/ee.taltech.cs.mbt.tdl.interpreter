package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.container.ParameterList;

public abstract class AbsFunctionDeclaration extends AbsDeclarationStatement {
	private Identifier name;
	private ParameterList parameters;
	private StatementBlock body;

	public Identifier getName() {
		return name;
	}

	public void setName(Identifier name) {
		this.name = name;
	}

	public ParameterList getParameters() {
		return parameters;
	}

	public void setParameters(ParameterList parameters) {
		this.parameters = parameters;
	}

	public StatementBlock getBody() {
		return body;
	}

	public void setBody(StatementBlock body) {
		this.body = body;
	}
}
