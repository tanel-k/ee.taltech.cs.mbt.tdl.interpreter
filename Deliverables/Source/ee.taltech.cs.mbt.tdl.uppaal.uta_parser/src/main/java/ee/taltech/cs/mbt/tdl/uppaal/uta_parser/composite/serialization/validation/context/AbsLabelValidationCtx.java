package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;

import java.util.Collection;
import java.util.Collections;

public abstract class AbsLabelValidationCtx<ParentCtxT extends AbsHierarchyValidationCtx<?, ?>> extends AbsHierarchyValidationCtx<AbsUtaLabel<?>, ParentCtxT> {
	AbsLabelValidationCtx(AbsUtaLabel<?> contextObject, ParentCtxT parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		AbsUtaLabel label = getContextObject();
		result.addErrorMessageIf(
				() -> (label instanceof IPositionable) && ((IPositionable) label).getCoordinates() == null,
				() -> "missing coordinates"
		);
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
