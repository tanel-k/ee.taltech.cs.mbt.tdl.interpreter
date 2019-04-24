package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.misc;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeTypeArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IArrayModifierVisitor;

import java.util.Set;

public class ArrayModifierCtxExtractor implements IPicklerContextExtractor<AbsArrayModifier>,
		IArrayModifierVisitor<ContextBuilder> {
	public static ArrayModifierCtxExtractor getInstance() {
		return new ArrayModifierCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			AbsArrayModifier.class
	);

	private ArrayModifierCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsArrayModifier modifier) {
		return ((AbsArrayModifier<?>) modifier).accept(this);
	}

	@Override
	public ContextBuilder visitSizeExpressionModifier(SizeExpressionArrayModifier modifier) {
		requiredClasses.add(modifier.getClass());
		ContextBuilder exprCtx = ExpressionCtxExtractor.getInstance()
				.extract(modifier.getSizeSpecifier(), requiredClasses);
		return ContextBuilder.newBuilder("sizeFromExpression")
				.put("sizeExpression", exprCtx);
	}

	@Override
	public ContextBuilder visitSizeTypeModifier(SizeTypeArrayModifier modifier) {
		requiredClasses.add(modifier.getClass());
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(modifier.getSizeSpecifier(), requiredClasses);
		return ContextBuilder.newBuilder("sizeFromType")
				.put("sizeType", baseTypeCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
