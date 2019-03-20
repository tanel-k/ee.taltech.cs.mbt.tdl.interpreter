package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ProcessRefs implements Iterable<IdentifierName> {
	private Set<IdentifierName> processIdentifiers = new LinkedHashSet<>();

	public Set<IdentifierName> getProcessIdentifiers() {
		return processIdentifiers;
	}

	@Override
	public Iterator<IdentifierName> iterator() {
		return processIdentifiers.iterator();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProcessIdentifiers());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProcessRefs))
			return false;
		ProcessRefs other = (ProcessRefs) obj;
		return Objects.equals(other.processIdentifiers, this.processIdentifiers);
	}
}
