package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;

public class TransitionLabelValidationCtx extends AbsLabelValidationCtx<TransitionValidationCtx> {
	TransitionLabelValidationCtx(AbsUtaLabel<?> contextObject, TransitionValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	public String getName() {
		return "transition label ("
					+ getContextObject().getClass().getName()
				+ ")";
	}
}
