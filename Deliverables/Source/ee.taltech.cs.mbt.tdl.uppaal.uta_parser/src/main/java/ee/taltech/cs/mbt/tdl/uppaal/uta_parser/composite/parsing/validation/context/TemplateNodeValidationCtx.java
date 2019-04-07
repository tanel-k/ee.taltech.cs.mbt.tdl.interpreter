package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.LocationNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.TemplateNode;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TemplateNodeValidationCtx extends AbsHierarchyValidationCtx<TemplateNode, UtaNodeValidationCtx> {
	private Collection<Object> getLocalLocIds() {
		return getCollectionMap()
				.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	private Collection<Object> getTemplateNames() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("templateNames"), k -> new HashSet<>());
	}

	TemplateNodeValidationCtx(TemplateNode contextObject, UtaNodeValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void prepareForValidation() {
		Collection<Object> locationIds = getLocalLocIds();
		getContextObject().getLocations().stream()
				.filter(LocationNode::isSetId)
				.map(LocationNode::getId)
				.forEach(locationIds::add);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		TemplateNode template = getContextObject();

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
					() -> !getLocalLocIds().contains(template.getInit().getRef()),
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
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		List<AbsHierarchyValidationCtx> children = new LinkedList<>();
		getContextObject().getLocations().stream()
				.map(location -> new LocationNodeValidationCtx(location, this))
				.forEach(children::add);
		getContextObject().getTransitions().stream()
				.map(transition -> new TransitionNodeValidationCtx(transition, this))
				.forEach(children::add);
		return children;
	}
}
