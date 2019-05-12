package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.misc;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeTypeArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IArrayModifierVisitor;

public class ArrayModifierCtxExtractor implements IContextExtractor<AbsArrayModifier>, IArrayModifierVisitor<ContextBuilder> {
	public static ArrayModifierCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final ArrayModifierCtxExtractor INSTANCE = new ArrayModifierCtxExtractor();

	private ArrayModifierCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsArrayModifier inst) {
		return ((AbsArrayModifier<?>) inst).accept(this);
	}

	@Override
	public ContextBuilder visitSizeExpressionModifier(SizeExpressionArrayModifier modifier) {
		ContextBuilder sizeCtx = ExpressionCtxExtractor.getInstance().extract(modifier.getSizeSpecifier());
		return ContextBuilder.newBuilder("sizeFromExpression")
				.put("sizeExpression", sizeCtx);
	}

	@Override
	public ContextBuilder visitSizeTypeModifier(SizeTypeArrayModifier modifier) {
		ContextBuilder sizeCtx = BaseTypeCtxExtractor.getInstance().extract(modifier.getSizeSpecifier());
		return ContextBuilder.newBuilder("sizeFromType")
				.put("sizeType", sizeCtx);
	}
}
