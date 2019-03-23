package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeLocationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ContextValidationResult;

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
	public String getName() {
		return "location label (" + (
				getContextObject().isSetKind()
					? getContextObject().getKind().value()
					: "unclassified"
			)+ ")";
	}

	@Override
	protected void performValidation(ContextValidationResult results) {
		XmlNodeLocationLabel label = getContextObject();

		if (!label.isSetValue())
			return;

		boolean missingKind = results.addErrorMessageIf(
			() -> !label.isSetKind(),
			() -> "missing kind"
		);
		results.addErrorMessageIf(
			() -> !label.isSetX() || !label.isSetKind(),
			() -> "missing coordinates"
		);

		if (!missingKind) {
			results.addErrorMessageIf(
				() -> getLabelKinds().contains(label.getKind()),
				() ->  "non-unique kind (" + label.getKind().value() + ")"
			);
			getLabelKinds().add(label.getKind());
		}
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
