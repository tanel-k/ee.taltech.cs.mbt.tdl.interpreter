package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.common_utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.common_utils.validation.AbsHierarchyRootValidationCtx;
import ee.taltech.cs.mbt.tdl.common_utils.validation.ContextValidationResult;

import java.util.Collection;
import java.util.stream.Collectors;

public class UtaNodeValidationCtx extends AbsHierarchyRootValidationCtx<UtaNode> {
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
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return getContextObject().getTemplates().stream()
				.map(template -> new TemplateNodeValidationCtx(template, this))
				.collect(Collectors.toList());
	}
}
