package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TransitionLabelNode;
import ee.taltech.cs.mbt.tdl.common_utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.common_utils.validation.ContextValidationResult;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class TransitionLabelNodeValidationCtx extends AbsHierarchyValidationCtx<TransitionLabelNode, TransitionNodeValidationCtx> {
	private Collection<Object> getLabelKinds() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("labelKinds"), k -> new HashSet<>());
	}

	TransitionLabelNodeValidationCtx(TransitionLabelNode contextObject, TransitionNodeValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void performValidation(ContextValidationResult results) {
		TransitionLabelNode label = getContextObject();
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
					() -> "non-unique kind"
			);
			getLabelKinds().add(label.getKind());
		}
	}

	@Override
	public String getName() {
		return "transition label (" + (
				getContextObject().isSetKind()
					? getContextObject().getKind().value()
					: "unclassified"
			) + ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		return Collections.emptyList();
	}
}
