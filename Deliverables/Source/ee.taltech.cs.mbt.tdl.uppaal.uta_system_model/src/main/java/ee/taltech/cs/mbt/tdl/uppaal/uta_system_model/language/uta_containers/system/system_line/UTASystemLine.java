package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.system.system_line;

import java.util.*;

public class UTASystemLine implements Iterable<ProcessRefList> {
	private Set<ProcessRefList> processPrioritySequence = new LinkedHashSet<>();

	public Set<ProcessRefList> getProcessPrioritySequence() {
		return processPrioritySequence;
	}

	@Override
	public Iterator<ProcessRefList> iterator() {
		return processPrioritySequence.iterator();
	}
}
