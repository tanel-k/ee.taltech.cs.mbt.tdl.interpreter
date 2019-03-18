package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.container.ParameterList;

public class PartialTemplateInstantiation extends ProcessVariableAssignment {
	private ParameterList remainingParams;

	public ParameterList getRemainingParams() {
		return remainingParams;
	}

	public void setRemainingParams(ParameterList remainingParams) {
		this.remainingParams = remainingParams;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitPartialTemplateInstantiation(this);
	}
}
