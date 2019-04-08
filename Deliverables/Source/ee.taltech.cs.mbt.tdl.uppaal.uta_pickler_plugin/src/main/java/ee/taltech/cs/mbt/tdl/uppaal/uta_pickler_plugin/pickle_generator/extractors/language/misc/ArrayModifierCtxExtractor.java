package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.misc;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeTypeArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IArrayModifierVisitor;

import java.util.Set;

public class ArrayModifierCtxExtractor implements IPicklerContextExtractor<AbsArrayModifier<?>>,
		IArrayModifierVisitor<ContextBuilder> {
	public static ArrayModifierCtxExtractor getInstance() {
		return new ArrayModifierCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private ArrayModifierCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsArrayModifier<?> modifier) {
		return modifier.accept(this);
	}

	@Override
	public ContextBuilder visitSizeExpressionModifier(SizeExpressionArrayModifier modifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitSizeTypeModifier(SizeTypeArrayModifier modifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
