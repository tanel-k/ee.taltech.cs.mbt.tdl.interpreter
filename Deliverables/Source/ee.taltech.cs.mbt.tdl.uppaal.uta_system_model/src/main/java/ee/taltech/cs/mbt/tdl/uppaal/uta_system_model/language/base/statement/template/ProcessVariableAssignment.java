package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.LinkedList;
import java.util.List;

public class ProcessVariableAssignment extends AbsDeclarationStatement {
	private Identifier processName;
	private List<AbsExpression> argumentList;

	public ProcessVariableAssignment() {
		this.argumentList = new LinkedList<>();
	}

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
}
