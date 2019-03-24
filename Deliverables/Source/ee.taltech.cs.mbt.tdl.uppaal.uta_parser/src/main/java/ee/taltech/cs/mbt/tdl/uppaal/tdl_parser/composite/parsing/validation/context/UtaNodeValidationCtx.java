package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidationRootCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ContextValidationResult;

import java.util.Collection;
import java.util.stream.Collectors;

public class UtaNodeValidationCtx extends AbsValidationRootCtx<UtaNode> {
	public UtaNodeValidationCtx(UtaNode xmlNode) {
		super(xmlNode);
	}

	@Override
	protected void performValidation(ContextValidationResult validationErrors) { }

	@Override
	public String getName() {
		return "system";
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return getContextObject().getTemplates().stream()
			.map(template -> new TemplateNodeValidationCtx(template, this))
			.collect(Collectors.toList());
	}
}
