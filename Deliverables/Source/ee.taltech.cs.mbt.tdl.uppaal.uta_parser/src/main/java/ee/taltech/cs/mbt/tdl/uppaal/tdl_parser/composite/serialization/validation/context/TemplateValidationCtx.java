package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TemplateValidationCtx extends AbsHierarchyValidationCtx<Template, UtaSystemValidationCtx> {
	private Collection<Object> getLocalLocIds() {
		return getCollectionMap()
				.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	private Collection<Object> getTemplateNames() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("templateNames"), k -> new HashSet<>());
	}

	@Override
	protected void prepareForValidation() {
		Collection<Object> locationIds = getLocalLocIds();
		getContextObject().getLocationGraph().getVertices().stream()
				.map(Location::getId)
				.forEach(locationIds::add);
	}

	TemplateValidationCtx(Template contextObject, UtaSystemValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		Template template = getContextObject();

		boolean missingName = result.addErrorMessageIf(
				() -> StringUtils.isEmpty(template.getName()),
				() -> "missing name"
		);
		result.addErrorMessageIf(
				() -> template.getLocationGraph().isEmpty(),
				() -> "no locations"
		);
		boolean missingInitialLocation = result.addErrorMessageIf(
				() -> template.getInitialLocation() == null,
				() -> "missing initial location"
		);

		if (!missingName) {
			result.addErrorMessageIf(
					() -> getTemplateNames().contains(template.getName()),
					() -> "non-unique name"
			);
			getTemplateNames().add(template.getName());
		}

		if (!missingInitialLocation) {
			result.addErrorMessageIf(
					() -> !getLocalLocIds().contains(template.getInitialLocation().getId()),
					() -> "non-existent initial location"
			);
		}
	}

	@Override
	public String getName() {
		return "template ("
					+ StringUtils.defaultString(getContextObject().getName(), "unnamed")
				+ ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		List<AbsHierarchyValidationCtx> children = new LinkedList<>();
		getContextObject().getLocationGraph().getEdges().stream()
				.map(t -> new TransitionValidationCtx(t, this))
				.forEach(children::add);
		getContextObject().getLocationGraph().getVertices().stream()
				.map(l -> new LocationValidationCtx(l, this))
				.forEach(children::add);
		return children;
	}
}
