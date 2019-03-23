package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNta;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationRootCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ContextValidationResult;

import java.util.Collection;
import java.util.stream.Collectors;

public class NtaValidationCtx extends AbsValidationRootCtx<XmlNodeNta> {
	public NtaValidationCtx(XmlNodeNta xmlNode) {
		super(xmlNode);
	}

	@Override
	protected void performValidation(ContextValidationResult validationErrors) { }

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return getContextObject().getTemplates().stream()
			.map(template -> new TemplateValidationCtx(template, this))
			.collect(Collectors.toList());
	}
}
