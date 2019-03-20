package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.system_line;

import java.util.*;

public class SystemLine implements Iterable<ProcessRefs> {
	private Set<ProcessRefs> processPrioritySequence = new LinkedHashSet<>();

	public Set<ProcessRefs> getProcessPrioritySequence() {
		return processPrioritySequence;
	}

	@Override
	public Iterator<ProcessRefs> iterator() {
		return processPrioritySequence.iterator();
	}
}
