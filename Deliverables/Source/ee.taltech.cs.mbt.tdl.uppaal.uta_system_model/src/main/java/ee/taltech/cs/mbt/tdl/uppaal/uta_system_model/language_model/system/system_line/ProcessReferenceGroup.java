package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProcessReferenceGroup implements Iterable<Identifier>, IDeepCloneable<ProcessReferenceGroup> {
	private List<Identifier> processIdentifiers = new LinkedList<>();

	public List<Identifier> getProcessIdentifiers() {
		return processIdentifiers;
	}

	public ProcessReferenceGroup addIdentifier(Identifier identifier) {
		getProcessIdentifiers().add(identifier);
		return this;
	}

	@Override
	public Iterator<Identifier> iterator() {
		return processIdentifiers.iterator();
	}

	@Override
	public ProcessReferenceGroup deepClone() {
		ProcessReferenceGroup clone = new ProcessReferenceGroup();
		processIdentifiers.stream().forEachOrdered(
				id -> clone.processIdentifiers.add(id.deepClone())
		);
		return clone;
	}
}
