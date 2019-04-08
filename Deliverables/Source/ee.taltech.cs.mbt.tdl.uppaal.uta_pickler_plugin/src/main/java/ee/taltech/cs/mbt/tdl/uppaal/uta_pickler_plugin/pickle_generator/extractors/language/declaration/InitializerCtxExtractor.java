package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.StructuredVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IInitializerVisitor;

import java.util.Set;

public class InitializerCtxExtractor implements IPicklerContextExtractor<AbsVariableInitializer>,
		IInitializerVisitor<ContextBuilder> {
	public static InitializerCtxExtractor getInstance() {
		return new InitializerCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private InitializerCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsVariableInitializer initializer) {
		return initializer.accept(this);
	}

	@Override
	public ContextBuilder visitFlatInitializer(FlatVariableInitializer init) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitStructuredInitializer(StructuredVariableInitializer init) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
