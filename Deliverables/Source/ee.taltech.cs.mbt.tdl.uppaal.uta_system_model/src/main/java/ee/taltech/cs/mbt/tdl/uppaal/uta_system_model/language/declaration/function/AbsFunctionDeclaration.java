package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.parameter.ParameterDeclaration;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * UPPAAL supports declaring value and void functions.<br/>
 * Syntax:<br/>
 * <pre>
 * Function ::= Type ID '(' Parameters ')' Block
 *           |  'void' ID '(' Parameters ')' Block
 * </pre>
 */
@Deprecated
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
