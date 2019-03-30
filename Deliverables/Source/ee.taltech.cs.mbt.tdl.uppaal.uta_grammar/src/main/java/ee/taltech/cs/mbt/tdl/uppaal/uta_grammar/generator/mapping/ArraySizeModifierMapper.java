package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.SizeTypeArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IArrayModifierVisitor;

public class ArraySizeModifierMapper implements IContextMapper<AbsArrayModifier>, IArrayModifierVisitor<ContextBuilder> {
	public static ArraySizeModifierMapper getInstance() {
		return INSTANCE;
	}

	private static final ArraySizeModifierMapper INSTANCE = new ArraySizeModifierMapper();

	private ArraySizeModifierMapper() { }

	@Override
	public ContextBuilder map(AbsArrayModifier inst) {
		return ((AbsArrayModifier<?>) inst).accept(this);
	}

	@Override
	public ContextBuilder visitSizeExpressionModifier(SizeExpressionArrayModifier modifier) {
		return ContextBuilder.newBuilder("sizeFromExpression").put(
				"sizeExpression",
				ExpressionMapper.getInstance().map(modifier.getSizeSpecifier())
		);
	}

	@Override
	public ContextBuilder visitSizeTypeModifier(SizeTypeArrayModifier modifier) {
		return ContextBuilder.newBuilder("sizeFromType").put(
				"sizeType",
				TypeMapper.getInstance().map(modifier.getSizeSpecifier())
		);
	}
}
