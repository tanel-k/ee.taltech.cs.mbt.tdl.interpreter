package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SystemLine implements Iterable<ProcessReferenceGroup> {
	private List<ProcessReferenceGroup> processPrioritySequence = new LinkedList<>();

	public List<ProcessReferenceGroup> getProcessPrioritySequence() {
		return processPrioritySequence;
	}

	@Override
	public Iterator<ProcessReferenceGroup> iterator() {
		return processPrioritySequence.iterator();
	}
}
