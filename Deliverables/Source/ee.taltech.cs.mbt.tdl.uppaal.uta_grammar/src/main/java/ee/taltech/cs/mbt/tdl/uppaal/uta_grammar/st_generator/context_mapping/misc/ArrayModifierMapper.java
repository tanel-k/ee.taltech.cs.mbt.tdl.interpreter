package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.misc;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type.BaseTypeMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeTypeArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IArrayModifierVisitor;

public class ArrayModifierMapper implements IContextMapper<AbsArrayModifier>, IArrayModifierVisitor<ContextBuilder> {
	public static ArrayModifierMapper getInstance() {
		return INSTANCE;
	}

	private static final ArrayModifierMapper INSTANCE = new ArrayModifierMapper();

	private ArrayModifierMapper() { }

	@Override
	public ContextBuilder map(AbsArrayModifier inst) {
		return ((AbsArrayModifier<?>) inst).accept(this);
	}

	@Override
	public ContextBuilder visitSizeExpressionModifier(SizeExpressionArrayModifier modifier) {
		ContextBuilder sizeCtx = ExpressionMapper.getInstance().map(modifier.getSizeSpecifier());
		return ContextBuilder.newBuilder("sizeFromExpression")
				.put("sizeExpression", sizeCtx);
	}

	@Override
	public ContextBuilder visitSizeTypeModifier(SizeTypeArrayModifier modifier) {
		ContextBuilder sizeCtx = BaseTypeMapper.getInstance().map(modifier.getSizeSpecifier());
		return ContextBuilder.newBuilder("sizeFromType")
				.put("sizeType", sizeCtx);
	}
}
