package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.process;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class PartialTemplateInstantiation extends ProcessVariableAssignment {
	private Set<ParameterDeclaration> remainingParameters = new LinkedHashSet<>();

	public Set<ParameterDeclaration> getRemainingParameters() {
		return remainingParameters;
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
			return Objects.equals(other.remainingParameters, this.remainingParameters);
		}
		return false;
	}
}
