package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTransitionNail;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ValidationError;

import java.util.Collection;
import java.util.Collections;

public class NailValidationCtx extends AbsValidationCtx<XmlNodeTransitionNail, TransitionValidationCtx> {
	NailValidationCtx(XmlNodeTransitionNail contextObject, TransitionValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult validationErrors) {
		XmlNodeTemplate template = getParentContext().getParentContext().getContextObject();
		XmlNodeTransitionNail nail = getContextObject();

		validationErrors.addErrorIf(
			() -> !nail.isSetX() || !nail.isSetY(),
			() -> ValidationError.forMessage("Nail for transition in " + template.getName() + " has no coordinates.")
		);
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
