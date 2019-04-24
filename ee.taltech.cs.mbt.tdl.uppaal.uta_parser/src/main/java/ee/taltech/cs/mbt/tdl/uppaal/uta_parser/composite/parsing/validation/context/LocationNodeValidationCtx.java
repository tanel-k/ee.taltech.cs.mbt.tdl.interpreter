package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.LocationNode;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LocationNodeValidationCtx extends AbsHierarchyValidationCtx<LocationNode, TemplateNodeValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	LocationNodeValidationCtx(LocationNode contextObject, TemplateNodeValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		LocationNode location = getContextObject();

		boolean missingId = result.addErrorMessageIf(
				() -> !location.isSetId(),
				() -> "missing id"
		);
		result.addErrorMessageIf(
				() -> !location.isSetX() || !location.isSetY(),
				() -> "missing coordinates"
		);
		result.addErrorMessageIf(
				() -> location.isSetUrgent() && location.isSetCommitted(),
				() -> "simultaneously urgent and committed"
		);

		if (!missingId) {
			result.addErrorMessageIf(
					() -> getLocationIds().contains(location.getId()),
					() -> "non-unique id: " + location.getId()
			);
			getLocationIds().add(location.getId());
		}
	}

	public String getName() {
		return "location (" + (
				getContextObject().isSetId()
						? getContextObject().getId()
						: "unidentified"
			) + ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return getContextObject().getLabels().stream()
				.map(label -> new LocationLabelNodeValidationCtx(label, this))
				.collect(Collectors.toList());
	}
}
