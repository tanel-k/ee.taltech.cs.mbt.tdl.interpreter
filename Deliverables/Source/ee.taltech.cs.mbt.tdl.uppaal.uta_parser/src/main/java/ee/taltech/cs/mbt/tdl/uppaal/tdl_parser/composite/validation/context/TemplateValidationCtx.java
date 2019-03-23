package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ValidationError;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TemplateValidationCtx extends AbsValidationCtx<XmlNodeTemplate, NtaValidationCtx> {
	private Collection<Object> getTemplateNames() {
		return getParentContext().getCollectionMap().computeIfAbsent("templateNames", k -> new HashSet<>());
	}

	TemplateValidationCtx(XmlNodeTemplate contextObject, NtaValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		XmlNodeTemplate template = getContextObject();

		boolean missingName = result.addErrorIf(
			() -> !template.isSetName() || !template.getName().isSetValue(),
			() -> ValidationError.forMessage("Template has no name.")
		);
		result.addErrorIf(
			() -> !template.isSetLocations(),
			() -> ValidationError.forMessage("Template " + template.getName() + " has no locations.")
		);
		result.addErrorIf(
			() -> !template.isSetInit() || !template.getInit().isSetRef(),
			() -> ValidationError.forMessage("Template " + template.getName() + " has no initial location.")
		);

		if (!missingName) {
			result.addErrorIf(
					() -> getTemplateNames().contains(template.getName().getValue()),
					() -> ValidationError.forMessage("Template name " + template.getName() + " is not unique.")
			);
			getTemplateNames().add(template.getName());
		}
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		List<AbsValidationCtx> children = new LinkedList<>();
		getContextObject().getLocations()
			.stream()
			.map(location -> new LocationValidationCtx(location, this))
			.forEach(children::add);
		getContextObject().getTransitions()
			.stream()
			.map(transition -> new TransitionValidationCtx(transition, this))
			.forEach(children::add);
		return children;
	}
}
