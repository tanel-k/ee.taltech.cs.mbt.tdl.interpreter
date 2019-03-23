package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.validation.context;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeLocation;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTransition;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.AbsValidationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.validation.ValidationError;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TransitionValidationCtx extends AbsValidationCtx<XmlNodeTransition, TemplateValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
			.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	TransitionValidationCtx(XmlNodeTransition contextObject, TemplateValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void prepareForValidation() {
		Collection<Object> locationIds = getLocationIds();
		if (locationIds.isEmpty()) {
			getParentContext().getContextObject().getLocations().stream()
				.filter(XmlNodeLocation::isSetId)
				.map(XmlNodeLocation::getId)
				.forEach(locationIds::add);
		}
	}

	@Override
	protected void performValidation(ContextValidationResult results) {
		XmlNodeTemplate template = getParentContext().getContextObject();
		XmlNodeTransition transition = getContextObject();

		boolean missingSource = results.addErrorIf(
			() -> !transition.isSetSource() || !transition.getSource().isSetRef(),
			() -> ValidationError.forMessage("Transition has no source reference in " + template.getName() + ".")
		);
		boolean missingTarget = results.addErrorIf(
			() -> !transition.isSetTarget() || !transition.getTarget().isSetRef(),
			() -> ValidationError.forMessage("Transition has no target reference in " + template.getName() + ".")
		);

		if (!missingSource) {
			String sourceRef = transition.getSource().getRef();
			results.addErrorIf(
				() -> !getLocationIds().contains(sourceRef),
				() -> ValidationError.forMessage("Transition refers to non-existent location in " + template.getName() + ".")
			);
		}

		if (!missingTarget) {
			String targetRef = transition.getTarget().getRef();
			results.addErrorIf(
				() -> !getLocationIds().contains(targetRef),
				() -> ValidationError.forMessage("Transition refers to non-existent location in " + template.getName() + ".")
			);
		}
	}

	@Override
	public Collection<AbsValidationCtx> orderedChildContexts() {
		List<AbsValidationCtx> children = new LinkedList<>();
		getContextObject().getLabels().stream()
			.map(label -> new TransitionLabelValidationCtx(label, this))
			.forEach(children::add);
		getContextObject().getNails().stream()
			.map(nail -> new NailValidationCtx(nail, this))
			.forEach(children::add);
		return children;
	}
}
