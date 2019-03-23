package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeLocation;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeLocationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ValidationError;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class LocationLabelValidationCtx extends AbsValidationCtx<XmlNodeLocationLabel, LocationValidationCtx> {
	private Collection<Object> getLabelKinds() {
		return getParentContext().getCollectionMap()
			.computeIfAbsent(qualifyKey("labelKinds"), k -> new HashSet<>());
	}

	LocationLabelValidationCtx(XmlNodeLocationLabel contextObject, LocationValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult results) {
		XmlNodeTemplate template = getParentContext().getParentContext().getContextObject();
		XmlNodeLocation location = getParentContext().getContextObject();
		XmlNodeLocationLabel label = getContextObject();
		if (!label.isSetValue())
			return;

		boolean missingKind = results.addErrorIf(
			label::isSetKind,
			() -> ValidationError.forMessage("Label for location " + location.getId() + " in " + template.getName() + " does not specify a kind.")
		);
		results.addErrorIf(
			() -> !label.isSetX() || !label.isSetKind(),
			() -> ValidationError.forMessage("Label for location " + location.getId() + " in " + template.getName() + " has no coordinates.")
		);

		if (!missingKind) {
			results.addErrorIf(
					() -> getLabelKinds().contains(label.getKind()),
					() -> ValidationError.forMessage(
							"Label for location " + location.getId() + " in " + template.getName() + " has duplicate labels of kind " + label.getKind() + ".")
			);
			getLabelKinds().add(label.getKind());
		}
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
