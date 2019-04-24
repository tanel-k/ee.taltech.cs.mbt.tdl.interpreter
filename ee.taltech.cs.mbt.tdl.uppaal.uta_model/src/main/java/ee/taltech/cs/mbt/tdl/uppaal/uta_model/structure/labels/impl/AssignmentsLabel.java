package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.ILabelVisitor;

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

	@Override
	public AssignmentsLabel deepClone() {
		AssignmentsLabel clone = new AssignmentsLabel();
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
