package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;

import java.util.Collection;
import java.util.LinkedList;

public class AssignmentsLabel extends AbsUtaLabel<Collection<AbsExpression>> implements IPositionable {
	public static AssignmentsLabel of(Collection<AbsExpression> expressions) {
		AssignmentsLabel label = new AssignmentsLabel();
		label.setContent(expressions == null ? new LinkedList<>() : expressions);
		return label;
	}

	private GuiCoordinates coordinates;

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public AssignmentsLabel setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitAssignments(this);
	}
}
