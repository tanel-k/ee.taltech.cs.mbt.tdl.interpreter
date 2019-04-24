package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.ILabelVisitor;

public class SynchronizationLabel extends AbsUtaLabel<Synchronization> implements IPositionable {
	public static SynchronizationLabel of(Synchronization synchronization) {
		SynchronizationLabel inst = new SynchronizationLabel();
		inst.setContent(synchronization);
		return inst;
	}

	private GuiCoordinates coordinates;

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public SynchronizationLabel setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitSynchronization(this);
	}

	@Override
	public SynchronizationLabel deepClone() {
		SynchronizationLabel clone = new SynchronizationLabel();
		clone.coordinates = coordinates;
		clone.setContent(
				getContent() != null
						? getContent().deepClone()
						: null
		);
		return clone;
	}
}
