package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line;

import java.util.*;

public class SystemLine implements Iterable<ProcessReferenceGroup> {
	private Set<ProcessReferenceGroup> processPrioritySequence = new LinkedHashSet<>();

	public Set<ProcessReferenceGroup> getProcessPrioritySequence() {
		return processPrioritySequence;
	}

	@Override
	public Iterator<ProcessReferenceGroup> iterator() {
		return processPrioritySequence.iterator();
	}
}
