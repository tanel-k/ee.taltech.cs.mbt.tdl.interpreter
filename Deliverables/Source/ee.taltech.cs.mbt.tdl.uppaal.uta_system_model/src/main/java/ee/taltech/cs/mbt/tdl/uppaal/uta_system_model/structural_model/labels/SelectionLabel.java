package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

import java.util.LinkedList;
import java.util.List;

public class SelectionLabel extends AbsUtaLabel<List<Selection>> {
	public static SelectionLabel of(List<Selection> expressions) {
		SelectionLabel inst = new SelectionLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}
}
