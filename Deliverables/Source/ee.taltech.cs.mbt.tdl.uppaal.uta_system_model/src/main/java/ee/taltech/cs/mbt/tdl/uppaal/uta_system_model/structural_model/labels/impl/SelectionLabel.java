package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;

import java.util.Collection;
import java.util.LinkedList;

public class SelectionLabel extends AbsUtaLabel<Collection<Selection>> {
	public static SelectionLabel of(Collection<Selection> expressions) {
		SelectionLabel inst = new SelectionLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitSelection(this);
	}
}
