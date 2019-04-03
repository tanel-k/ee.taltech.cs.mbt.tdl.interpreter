package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyRootValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Collection;
import java.util.stream.Collectors;

public class UtaSystemValidationCtx extends AbsHierarchyRootValidationCtx<UtaSystem> {
	public UtaSystemValidationCtx(UtaSystem ctxObj) {
		super(ctxObj);
	}

	@Override
	protected void performValidation(ContextValidationResult results) { }

	@Override
	public String getName() {
		return "system";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return getContextObject().getTemplateMap().values()
				.stream()
				.map(t -> new TemplateValidationCtx(t, this))
				.collect(Collectors.toList());
	}
}
