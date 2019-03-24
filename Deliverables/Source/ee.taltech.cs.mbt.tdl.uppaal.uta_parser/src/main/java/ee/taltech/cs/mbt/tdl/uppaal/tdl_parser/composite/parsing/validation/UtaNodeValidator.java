package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context.UtaNodeValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidator;

public class UtaNodeValidator extends AbsValidator<UtaNodeValidationCtx> {
	public static UtaNodeValidator newInstance(UtaNode nta) {
		return new UtaNodeValidator(new UtaNodeValidationCtx(nta));
	}

	private UtaNodeValidator(UtaNodeValidationCtx rootContext) {
		super(rootContext);
	}
}
