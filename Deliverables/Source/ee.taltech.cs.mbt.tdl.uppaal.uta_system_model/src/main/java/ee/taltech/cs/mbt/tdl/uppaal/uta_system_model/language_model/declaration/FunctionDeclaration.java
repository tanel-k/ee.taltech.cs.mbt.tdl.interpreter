package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * UPPAAL supports declaring value and void functions.<br/>
 * Syntax:<br/>
 * <pre>
 * Function ::= Type ID '(' Parameters ')' Block
 *           |  'void' ID '(' Parameters ')' Block
 * </pre>
 */
public class FunctionDeclaration extends AbsDeclarationStatement {
	private BaseType valueType;
	private Identifier name;
	private List<ParameterDeclaration> parameters = new LinkedList<>();
	private StatementBlock statementBlock;

	public BaseType getValueType() {
		return valueType;
	}

	public void setValueType(BaseType valueType) {
		this.valueType = valueType;
	}

	public Identifier getName() {
		return name;
	}

	public void setName(Identifier name) {
		this.name = name;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	public StatementBlock getStatementBlock() {
		return statementBlock;
	}

	public void setStatementBlock(StatementBlock statementBlock) {
		this.statementBlock = statementBlock;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitFunctionDeclaration(this);
	}
}
