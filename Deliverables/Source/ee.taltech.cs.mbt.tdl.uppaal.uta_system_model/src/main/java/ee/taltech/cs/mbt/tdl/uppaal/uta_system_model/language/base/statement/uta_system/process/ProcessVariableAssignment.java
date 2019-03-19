package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system.process;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system.AbsSystemDeclarationStatement;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProcessVariableAssignment extends AbsSystemDeclarationStatement {
	private Identifier processName;
	private List<AbsExpression> argumentList = new LinkedList<>();

	public Identifier getProcessName() {
		return processName;
	}

	public void setProcessName(Identifier processName) {
		this.processName = processName;
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
