package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;

public class LocationLabelValidationCtx extends AbsLabelValidationCtx<LocationValidationCtx> {
	LocationLabelValidationCtx(AbsUtaLabel<?> contextObject, LocationValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	public String getName() {
		return "location label ("
					+ getContextObject().getClass().getName()
				+ ")";
	}
}
