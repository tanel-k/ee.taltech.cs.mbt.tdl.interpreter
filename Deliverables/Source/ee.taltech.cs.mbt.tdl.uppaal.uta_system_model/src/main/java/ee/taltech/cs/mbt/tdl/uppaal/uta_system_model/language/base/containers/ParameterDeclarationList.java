package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.containers;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.ParameterDeclaration;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ParameterDeclarationList implements Iterable<ParameterDeclaration> {
	private Set<ParameterDeclaration> parameterDeclarations = new LinkedHashSet<>();

	public Set<ParameterDeclaration> getParameterDeclarations() {
		return parameterDeclarations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getParameterDeclarations());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ParameterDeclarationList))
			return false;
		ParameterDeclarationList other = (ParameterDeclarationList) obj;
		return Objects.equals(other.parameterDeclarations, this.parameterDeclarations);
	}

	@Override
	public Iterator<ParameterDeclaration> iterator() {
		return parameterDeclarations.iterator();
	}
}
