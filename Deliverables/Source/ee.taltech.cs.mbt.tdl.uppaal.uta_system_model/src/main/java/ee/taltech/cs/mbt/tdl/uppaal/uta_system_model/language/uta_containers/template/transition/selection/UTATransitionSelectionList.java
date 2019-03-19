package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.template.transition.selection;

import java.util.LinkedList;
import java.util.List;

public class UTATransitionSelectionList {
	private List<Selection> selections;

	public UTATransitionSelectionList() {
		this.selections = new LinkedList<>();
	}

	public List<Selection> getSelections() {
		return selections;
	}
}
