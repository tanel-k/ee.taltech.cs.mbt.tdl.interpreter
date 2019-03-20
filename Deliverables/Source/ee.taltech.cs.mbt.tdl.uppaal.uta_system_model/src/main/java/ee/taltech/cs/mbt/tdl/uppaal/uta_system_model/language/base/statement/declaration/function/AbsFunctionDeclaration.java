package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbsFunctionDeclaration extends AbsDeclarationStatement {
	private IdentifierName name;
	private Set<ParameterDeclaration> parameterDeclarations = new LinkedHashSet<>();
	private StatementBlock body;

	public IdentifierName getName() {
		return name;
	}

	public void setName(IdentifierName name) {
		this.name = name;
	}

	public Set<ParameterDeclaration> getParameterDeclarations() {
		return parameterDeclarations;
	}

	public StatementBlock getBody() {
		return body;
	}

	public void setBody(StatementBlock body) {
		this.body = body;
	}
}
