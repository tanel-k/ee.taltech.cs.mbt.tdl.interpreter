package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.validation;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.validation.context.UtaNodeValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.UtaNode;

public class UtaNodeValidator extends AbsHierarchyValidator<UtaNodeValidationCtx> {
	public static UtaNodeValidator newInstance(UtaNode nta) {
		return new UtaNodeValidator(new UtaNodeValidationCtx(nta));
	}

	private UtaNodeValidator(UtaNodeValidationCtx rootContext) {
		super(rootContext);
	}
}
