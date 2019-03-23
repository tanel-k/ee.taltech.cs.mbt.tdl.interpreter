package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeLocation;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ContextValidationResult;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TemplateValidationCtx extends AbsValidationCtx<XmlNodeTemplate, NtaValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
			.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	private Collection<Object> getTemplateNames() {
		return getParentContext().getCollectionMap()
			.computeIfAbsent(qualifyKey("templateNames"), k -> new HashSet<>());
	}

	TemplateValidationCtx(XmlNodeTemplate contextObject, NtaValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void prepareForValidation() {
		Collection<Object> locationIds = getLocationIds();
		getContextObject().getLocations().stream()
			.filter(XmlNodeLocation::isSetId)
			.map(XmlNodeLocation::getId)
			.forEach(locationIds::add);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		XmlNodeTemplate template = getContextObject();

		boolean missingName = result.addErrorMessageIf(
			() -> !template.isSetName() || !template.getName().isSetValue(),
			() -> "missing name"
		);
		result.addErrorMessageIf(
			() -> !template.isSetLocations(),
			() -> "no locations"
		);
		boolean missingInitialLocation = result.addErrorMessageIf(
			() -> !template.isSetInit() || !template.getInit().isSetRef(),
			() -> "missing initial location"
		);

		if (!missingName) {
			result.addErrorMessageIf(
				() -> getTemplateNames().contains(template.getName().getValue()),
				() -> "non-unique name"
			);
			getTemplateNames().add(template.getName());
		}

		if (!missingInitialLocation) {
			result.addErrorMessageIf(
				() -> !getLocationIds().contains(template.getInit().getRef()),
				() -> "non-existent initial location"
			);
		}
	}

	@Override
	public String getName() {
		return "template (" + (
				getContextObject().isSetName() && getContextObject().getName().isSetValue()
					? getContextObject().getName().getValue()
					: "unnamed"
			) + ")";
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
