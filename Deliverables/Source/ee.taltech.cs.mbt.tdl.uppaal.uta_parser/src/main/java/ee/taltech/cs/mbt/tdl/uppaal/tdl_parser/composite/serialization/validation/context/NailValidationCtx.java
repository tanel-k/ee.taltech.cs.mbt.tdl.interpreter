package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition.Nail;

import java.util.Collection;
import java.util.Collections;

public class NailValidationCtx extends AbsHierarchyValidationCtx<Nail, TransitionValidationCtx> {
	NailValidationCtx(Nail contextObject, TransitionValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		Nail nail = getContextObject();
		result.addErrorMessageIf(
				() -> nail.getCoordinates() == null,
				() -> "missing coordinates"
		);
	}

	@Override
	public String getName() {
		GuiCoordinates coordinates = getContextObject().getCoordinates();
		String x = coordinates == null
				? "?"
				: String.valueOf(coordinates.getX());
		String y = coordinates == null
				? "?"
				: String.valueOf(coordinates.getY());
		return "nail (" + x + "," + y + ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
