package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

import java.util.LinkedList;
import java.util.List;

public class UtaSelectionLabel extends AbsUtaLabel<List<Selection>> {
	public static UtaSelectionLabel of(List<Selection> expressions) {
		UtaSelectionLabel inst = new UtaSelectionLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}
}
