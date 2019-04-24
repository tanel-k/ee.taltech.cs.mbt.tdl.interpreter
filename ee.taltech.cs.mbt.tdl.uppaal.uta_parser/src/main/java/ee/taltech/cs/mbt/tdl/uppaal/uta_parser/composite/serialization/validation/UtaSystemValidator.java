package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.validation;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.validation.context.UtaSystemValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

public class UtaSystemValidator extends AbsHierarchyValidator<UtaSystemValidationCtx> {
	public static UtaSystemValidator newInstance(UtaSystem utaSystem) {
		return new UtaSystemValidator(new UtaSystemValidationCtx(utaSystem));
	}

	private UtaSystemValidator(UtaSystemValidationCtx rootContext) {
		super(rootContext);
	}
}
