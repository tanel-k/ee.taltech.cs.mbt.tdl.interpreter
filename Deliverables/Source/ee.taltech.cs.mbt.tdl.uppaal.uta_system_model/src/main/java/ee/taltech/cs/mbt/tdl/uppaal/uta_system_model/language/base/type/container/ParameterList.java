package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.container;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.ParameterType;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ParameterList {
	private Set<ParameterType> parameters;

	public ParameterList() {
		this.parameters = new LinkedHashSet<>();
	}

	public Set<ParameterType> getParameters() {
		return parameters;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parameters);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ParameterList))
			return false;
		ParameterList other = (ParameterList) obj;
		return Objects.equals(other.parameters, this.parameters);
	}
}
