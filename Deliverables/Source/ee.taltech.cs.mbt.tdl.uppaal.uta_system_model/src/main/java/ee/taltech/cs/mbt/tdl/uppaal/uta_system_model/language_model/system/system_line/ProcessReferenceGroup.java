package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProcessReferenceGroup implements Iterable<Identifier> {
	private List<Identifier> processIdentifiers = new LinkedList<>();

	public List<Identifier> getProcessIdentifiers() {
		return processIdentifiers;
	}

	@Override
	public Iterator<Identifier> iterator() {
		return processIdentifiers.iterator();
	}
}
