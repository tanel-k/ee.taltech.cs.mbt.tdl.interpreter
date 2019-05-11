package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.templates;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.BiTuple;
import ee.taltech.cs.mbt.tdl.commons.utils.functions.NoOpConsumer;
import ee.taltech.cs.mbt.tdl.commons.utils.streams.StreamUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.parameter.ParameterCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.locations.LocationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.transitions.TransitionCtxExtractor;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TemplateCtxExtractor implements IPicklerContextExtractor<Template> {
	public static TemplateCtxExtractor getInstance() {
		return new TemplateCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Template.class,
			TemplateInstantiation.class,
			AbsExpression.class,
			Identifier.class
	);

	private TemplateCtxExtractor() { }

	@Override
	public ContextBuilder extract(Template template) {
		Collection<ContextBuilder> parameterCtxs = ParameterCtxExtractor.getInstance()
				.extract(template.getParameters(), requiredClasses);
		Collection<ContextBuilder> declarationCtxs = DeclarationCtxExtractor.getInstance()
				.extract(template.getDeclarations(), requiredClasses);
		Collection<ContextBuilder> locationCtxs = new LinkedList<>();
		for (Location location : template.getLocationGraph().getVertices()) {
			ContextBuilder locationCtx = LocationCtxExtractor.getInstance()
					.extract(location, requiredClasses);
			if (template.getInitialLocation().equals(location))
				locationCtx.put("initial", true);
			locationCtxs.add(locationCtx);
		}

		// Ensure transition constructors are distinct if required:
		List<Transition> transitions = new LinkedList<>();
		List<String> transitionNameQualifiers = new LinkedList<>();
		Map<BiTuple<String, String>, Integer> transitionCounts = new HashMap<>();
		for (Transition transition : template.getLocationGraph().getEdges()) {
			transitions.add(transition);
			BiTuple<String, String> idPair = BiTuple.of(transition.getSource().getId(), transition.getTarget().getId());
			int count = transitionCounts.computeIfAbsent(idPair, k -> 0) + 1;
			transitionCounts.put(idPair, count);
			transitionNameQualifiers.add("_Nr" + String.valueOf(count));
		}

		Collection<ContextBuilder> transitionCtxs = TransitionCtxExtractor.getInstance()
				.extract(transitions, requiredClasses);
		StreamUtils.zipSequential(transitionCtxs.stream(), transitionNameQualifiers.stream(), (ctx, qualifier, i) -> {
				Transition transition = transitions.get(i);
				BiTuple<String, String> idPair = BiTuple.of(transition.getSource().getId(), transition.getTarget().getId());
				if (transitionCounts.computeIfAbsent(idPair, k -> 1) > 1)
					ctx.put("qualifier", qualifier);
				return null;
		}).forEachOrdered(NoOpConsumer.INSTANCE);

		return ContextBuilder.newBuilder()
				.put("name", template.getName())
				.put("parameters", parameterCtxs)
				.put("declarations", declarationCtxs)
				.put("locations", locationCtxs)
				.put("transitions", transitionCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
