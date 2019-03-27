package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ProcessReferenceGroup implements Iterable<Identifier> {
	private Set<Identifier> processIdentifiers = new LinkedHashSet<>();

	public Set<Identifier> getProcessIdentifiers() {
		return processIdentifiers;
	}

	@Override
	public Iterator<Identifier> iterator() {
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
		if (!(obj instanceof ProcessReferenceGroup))
			return false;
		ProcessReferenceGroup other = (ProcessReferenceGroup) obj;
		return Objects.equals(other.processIdentifiers, this.processIdentifiers);
	}
}
