package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.ILabelVisitor;

import java.util.Collection;
import java.util.LinkedList;

public class SelectionLabel extends AbsUtaLabel<Collection<Selection>> implements IPositionable {
	public static SelectionLabel of(Collection<Selection> expressions) {
		SelectionLabel inst = new SelectionLabel();
		inst.setContent(expressions == null ? new LinkedList<>() : expressions);
		return inst;
	}

	private GuiCoordinates coordinates;

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public SelectionLabel setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitSelection(this);
	}

	@Override
	public SelectionLabel deepClone() {
		SelectionLabel clone = new SelectionLabel();
		clone.coordinates = coordinates;
		if (getContent() != null) {
			clone.setContent(new LinkedList<>());
			getContent().stream().forEachOrdered(
					expr -> clone.getContent().add(expr.deepClone())
			);
		}
		return clone;
	}
}
