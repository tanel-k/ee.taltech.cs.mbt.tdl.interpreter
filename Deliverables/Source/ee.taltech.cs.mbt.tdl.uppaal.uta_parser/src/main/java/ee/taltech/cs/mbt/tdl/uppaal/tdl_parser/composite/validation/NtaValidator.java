package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context.NtaValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidator;

public class NtaValidator extends AbsValidator<NtaValidationCtx> {
	public static NtaValidator newInstance(XmlNodeNta nta) {
		return new NtaValidator(new NtaValidationCtx(nta));
	}

	private NtaValidator(NtaValidationCtx rootContext) {
		super(rootContext);
	}
}
