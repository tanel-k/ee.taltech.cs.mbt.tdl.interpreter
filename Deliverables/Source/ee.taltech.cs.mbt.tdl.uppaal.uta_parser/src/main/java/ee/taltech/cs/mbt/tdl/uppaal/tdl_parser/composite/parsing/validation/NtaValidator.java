package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context.NtaValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidator;

public class NtaValidator extends AbsValidator<NtaValidationCtx> {
	public static NtaValidator newInstance(XmlNodeNta nta) {
		return new NtaValidator(new NtaValidationCtx(nta));
	}

	private NtaValidator(NtaValidationCtx rootContext) {
		super(rootContext);
	}
}
