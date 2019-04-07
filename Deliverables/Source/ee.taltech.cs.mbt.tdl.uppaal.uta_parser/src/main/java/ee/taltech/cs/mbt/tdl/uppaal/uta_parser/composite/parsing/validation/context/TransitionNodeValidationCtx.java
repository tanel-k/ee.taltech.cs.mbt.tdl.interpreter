package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.LocationNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.TransitionNode;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TransitionNodeValidationCtx extends AbsHierarchyValidationCtx<TransitionNode, TemplateNodeValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	TransitionNodeValidationCtx(TransitionNode contextObject, TemplateNodeValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void prepareForValidation() {
		Collection<Object> locationIds = getLocationIds();
		if (locationIds.isEmpty()) {
			getParentContext().getContextObject().getLocations().stream()
					.filter(LocationNode::isSetId)
					.map(LocationNode::getId)
					.forEach(locationIds::add);
		}
	}

	@Override
	protected void performValidation(ContextValidationResult results) {
		TransitionNode transition = getContextObject();

		boolean missingSource = results.addErrorMessageIf(
				() -> !transition.isSetSource() || !transition.getSource().isSetRef(),
				() -> "missing source reference"
		);
		boolean missingTarget = results.addErrorMessageIf(
				() -> !transition.isSetTarget() || !transition.getTarget().isSetRef(),
				() -> "missing target reference"
		);

		if (!missingSource) {
			String sourceRef = transition.getSource().getRef();
			results.addErrorMessageIf(
					() -> !getLocationIds().contains(sourceRef),
					() -> "refers to non-existent source location"
			);
		}

		if (!missingTarget) {
			String targetRef = transition.getTarget().getRef();
			results.addErrorMessageIf(
					() -> !getLocationIds().contains(targetRef),
					() -> "refers to non-existent target location"
			);
		}
	}

	@Override
	public String getName() {
		String sourceName = getContextObject().isSetSource() && getContextObject().getSource().isSetRef()
				? getContextObject().getSource().getRef()
				: "unspecified";
		String targetName = getContextObject().isSetTarget() && getContextObject().getTarget().isSetRef()
				? getContextObject().getSource().getRef()
				: "unspecified";
		return "transition (" + sourceName + " -> " + targetName + ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		List<AbsHierarchyValidationCtx> children = new LinkedList<>();
		getContextObject().getLabels().stream()
				.map(label -> new TransitionLabelNodeValidationCtx(label, this))
				.forEach(children::add);
		getContextObject().getNails().stream()
				.map(nail -> new NailNodeValidationCtx(nail, this))
				.forEach(children::add);
		return children;
	}
}
