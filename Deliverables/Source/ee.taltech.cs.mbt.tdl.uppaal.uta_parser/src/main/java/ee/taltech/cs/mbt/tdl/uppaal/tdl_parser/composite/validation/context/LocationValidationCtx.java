package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeLocation;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ValidationError;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LocationValidationCtx extends AbsValidationCtx<XmlNodeLocation, TemplateValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
			.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	LocationValidationCtx(XmlNodeLocation contextObject, TemplateValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		XmlNodeTemplate template = getParentContext().getContextObject();
		XmlNodeLocation location = getContextObject();

		boolean missingId = result.addErrorIf(
			() -> !location.isSetId(),
			() -> ValidationError.forMessage("Location has no identifier in " + template.getName())
		);
		result.addErrorIf(
			() -> !location.isSetX() || !location.isSetY(),
			() -> ValidationError.forMessage("Location " + location.getId() + " in " + template.getName() + " has no coordinates.")
		);
		result.addErrorIf(
			() -> !location.isSetUrgent() && location.isSetCommitted(),
			() -> ValidationError.forMessage("Location " + location.getId() + " in " + template.getName() + " cannot be both urgent and committed at the same time.")
		);

		if (!missingId) {
			result.addErrorIf(
					() -> getLocationIds().contains(location.getId()),
					() -> ValidationError.forMessage("Location id " + location.getId() + " is not unique in " + template.getName())
			);
			getLocationIds().add(location.getId());
		}
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return getContextObject().getLabels().stream()
			.map(label -> new LocationLabelValidationCtx(label, this))
			.collect(Collectors.toList());
	}
}
