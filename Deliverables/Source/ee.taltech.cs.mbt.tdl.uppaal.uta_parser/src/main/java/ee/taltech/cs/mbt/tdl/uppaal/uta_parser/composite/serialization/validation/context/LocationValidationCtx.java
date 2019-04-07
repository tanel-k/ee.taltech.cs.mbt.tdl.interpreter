package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LocationValidationCtx extends AbsHierarchyValidationCtx<Location, TemplateValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	LocationValidationCtx(Location contextObject, TemplateValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		Location location = getContextObject();

		boolean missingId = result.addErrorMessageIf(
				() -> StringUtils.isEmpty(location.getId()),
				() -> "missing id"
		);
		result.addErrorMessageIf(
				() -> location.getCoordinates() == null,
				() -> "missing coordinates"
		);

		if (!missingId) {
			result.addErrorMessageIf(
					() -> getLocationIds().contains(location.getId()),
					() -> "non-unique id"
			);
			getLocationIds().add(location.getId());
		}
	}

	@Override
	public String getName() {
		return "location ("
					+ StringUtils.defaultString(getContextObject().getId(), "unidentified")
				+ ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return getContextObject().getLabels().asCollection().stream()
				.map(l -> new LocationLabelValidationCtx(l, this))
				.collect(Collectors.toList());
	}
}
