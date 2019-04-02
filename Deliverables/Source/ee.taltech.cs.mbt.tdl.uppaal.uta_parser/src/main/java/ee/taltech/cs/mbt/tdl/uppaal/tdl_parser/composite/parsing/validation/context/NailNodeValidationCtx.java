package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TransitionNailNode;
import ee.taltech.cs.mbt.tdl.common_utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.common_utils.validation.ContextValidationResult;

import java.util.Collection;
import java.util.Collections;

public class NailNodeValidationCtx extends AbsHierarchyValidationCtx<TransitionNailNode, TransitionNodeValidationCtx> {
	NailNodeValidationCtx(TransitionNailNode contextObject, TransitionNodeValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult validationErrors) {
		TransitionNailNode nail = getContextObject();

		validationErrors.addErrorMessageIf(
				() -> !nail.isSetX() || !nail.isSetY(),
				() -> "missing coordinates"
		);
	}

	@Override
	public String getName() {
		String x = getContextObject().isSetX()
				? String.valueOf(getContextObject().getX())
				: "?";
		String y = getContextObject().isSetY()
				? String.valueOf(getContextObject().getY())
				: "?";
		return "nail (" + x + "," + y + ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
