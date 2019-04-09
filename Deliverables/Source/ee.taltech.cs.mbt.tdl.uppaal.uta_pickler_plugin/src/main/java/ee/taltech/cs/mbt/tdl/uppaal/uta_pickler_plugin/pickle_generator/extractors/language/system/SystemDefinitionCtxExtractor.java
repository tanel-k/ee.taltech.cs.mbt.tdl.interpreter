package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.system;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;

import java.util.Collection;
import java.util.Set;

public class SystemDefinitionCtxExtractor implements IPicklerContextExtractor<SystemDefinition> {
	public static SystemDefinitionCtxExtractor getInstance() {
		return new SystemDefinitionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			SystemDefinition.class
	);

	private SystemDefinitionCtxExtractor() { }

	@Override
	public ContextBuilder extract(SystemDefinition systemDefinition) {
		ContextBuilder systemLineCtx = systemDefinition.getSystemLine() != null
				? SystemLineCtxExtractor.getInstance().extract(systemDefinition.getSystemLine(), requiredClasses)
				: null;
		Collection<ContextBuilder> declCtxs = DeclarationCtxExtractor.getInstance()
				.extract(systemDefinition.getDeclarations(), requiredClasses);
		Collection<ContextBuilder> progressMeasures = ExpressionCtxExtractor.getInstance()
				.extract(systemDefinition.getProgressMeasureExpressions(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("systemLine", systemLineCtx)
				.put("declarations", declCtxs)
				.put("progressMeasures", progressMeasures);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
