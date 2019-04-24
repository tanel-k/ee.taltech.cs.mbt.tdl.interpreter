package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.ILabelVisitor;

public class GuardLabel extends AbsUtaLabel<AbsExpression> implements IPositionable {
	public static GuardLabel of(AbsExpression expression) {
		GuardLabel inst = new GuardLabel();
		inst.setContent(expression);
		return inst;
	}

	private GuiCoordinates coordinates;

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public GuardLabel setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitGuard(this);
	}

	@Override
	public GuardLabel deepClone() {
		GuardLabel clone = new GuardLabel();
		clone.coordinates = coordinates;
		clone.setContent(
				getContent() != null
						? getContent().deepClone()
						: null
		);
		return clone;
	}
}
