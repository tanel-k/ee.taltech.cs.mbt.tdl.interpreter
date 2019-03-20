package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.process;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.AbsSystemDeclarationStatement;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProcessVariableAssignment extends AbsSystemDeclarationStatement {
	private IdentifierName processName;
	private IdentifierName templateName;
	private List<AbsExpression> argumentList = new LinkedList<>();

	public IdentifierName getProcessName() {
		return processName;
	}

	public void setProcessName(IdentifierName processName) {
		this.processName = processName;
	}

	public IdentifierName getTemplateName() {
		return templateName;
	}

	public void setTemplateName(IdentifierName templateName) {
		this.templateName = templateName;
	}

	public List<AbsExpression> getArgumentList() {
		return argumentList;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitTemplateInstantiation(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProcessName(), getArgumentList());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProcessVariableAssignment))
			return false;
		ProcessVariableAssignment other = (ProcessVariableAssignment) obj;
		return Objects.equals(other.processName, this.processName)
			&& Objects.equals(other.argumentList, this.argumentList);
	}
}
