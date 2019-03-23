package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTransitionNail;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ContextValidationResult;

import java.util.Collection;
import java.util.Collections;

public class NailValidationCtx extends AbsValidationCtx<XmlNodeTransitionNail, TransitionValidationCtx> {
	NailValidationCtx(XmlNodeTransitionNail contextObject, TransitionValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult validationErrors) {
		XmlNodeTransitionNail nail = getContextObject();

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
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
