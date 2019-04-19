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

	public FunctionDeclaration setValueType(BaseType valueType) {
		this.valueType = valueType;
		return this;
	}

	public Identifier getName() {
		return name;
	}

	public FunctionDeclaration setName(Identifier name) {
		this.name = name;
		return this;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	public FunctionDeclaration addParameter(ParameterDeclaration parameter) {
		getParameters().add(parameter);
		return this;
	}

	public StatementBlock getStatementBlock() {
		return statementBlock;
	}

	public FunctionDeclaration setStatementBlock(StatementBlock statementBlock) {
		this.statementBlock = statementBlock;
		return this;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitFunctionDeclaration(this);
	}

	@Override
	public FunctionDeclaration deepClone() {
		FunctionDeclaration clone = new FunctionDeclaration();

		clone.name = name.deepClone();
		clone.valueType = valueType != null
				? valueType.deepClone()
				: null;
		parameters.stream()
				.map(ParameterDeclaration::deepClone)
				.forEachOrdered(clone.parameters::add);
		clone.statementBlock = getStatementBlock().deepClone();

		return clone;
	}
}
