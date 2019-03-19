package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.uta_system.process;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers.ParameterDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.Objects;

public class PartialTemplateInstantiation extends ProcessVariableAssignment {
	private ParameterDeclarationList parameters;

	public ParameterDeclarationList getRemainingParameters() {
		return parameters;
	}

	public void setRemainingParameters(ParameterDeclarationList parameters) {
		this.parameters = parameters;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitPartialTemplateInstantiation(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getRemainingParameters());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof PartialTemplateInstantiation))
				return false;
			PartialTemplateInstantiation other = (PartialTemplateInstantiation) obj;
			return Objects.equals(other.parameters, this.parameters);
		}
		return false;
	}
}
