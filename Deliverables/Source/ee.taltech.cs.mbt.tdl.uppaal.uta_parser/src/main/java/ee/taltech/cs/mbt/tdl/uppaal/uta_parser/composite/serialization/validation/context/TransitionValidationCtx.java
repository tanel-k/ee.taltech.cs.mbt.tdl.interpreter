package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.validation.context;

import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.AbsHierarchyValidationCtx;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ContextValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TransitionValidationCtx extends AbsHierarchyValidationCtx<Transition, TemplateValidationCtx> {
	private Collection<Object> getLocationIds() {
		return getParentContext().getCollectionMap()
				.computeIfAbsent(qualifyKey("locationIds"), k -> new HashSet<>());
	}

	TransitionValidationCtx(Transition contextObject, TemplateValidationCtx parentCtx) {
		super(contextObject, parentCtx);
	}

	@Override
	protected void prepareForValidation() {
		Collection<Object> locationIds = getLocationIds();
		if (locationIds.isEmpty()) {
			getParentContext().getContextObject().getLocationGraph().getVertices().stream()
					.map(Location::getId)
					.filter(s -> !StringUtils.isEmpty(s))
					.forEach(locationIds::add);
		}
	}

	@Override
	protected void performValidation(ContextValidationResult result) {
		Transition transition = getContextObject();

		boolean missingSource = result.addErrorMessageIf(
				() -> transition.getSource() == null,
				() -> "missing source location"
		);
		boolean missingTarget = result.addErrorMessageIf(
				() -> transition.getTarget() == null,
				() -> "missing target location"
		);

		if (!missingSource) {
			String sourceId = transition.getSource().getId();
			result.addErrorMessageIf(
					() -> !getLocationIds().contains(sourceId),
					() -> "refers to non-existent source location"
			);
		}

		if (!missingTarget) {
			String targetId = transition.getTarget().getId();
			result.addErrorMessageIf(
					() -> !getLocationIds().contains(targetId),
					() -> "refers to non-existent target location"
			);
		}
	}

	@Override
	public String getName() {
		Location source = getContextObject().getSource();
		Location target = getContextObject().getTarget();
		return "transition ("
				+ StringUtils.defaultString(source.getId(), "unspecified")
				+ " -> "
				+ StringUtils.defaultString(target.getId(), "unspecified")
			+ ")";
	}

	@Override
	public Collection<AbsHierarchyValidationCtx> orderedChildContexts() {
		List<AbsHierarchyValidationCtx> children = new LinkedList<>();
		getContextObject().getLabels().asCollection().stream()
				.map(label -> new TransitionLabelValidationCtx(label, this))
				.forEach(children::add);
		getContextObject().getNails().stream()
				.map(nail -> new NailValidationCtx(nail, this))
				.forEach(children::add);
		return children;
	}
}
