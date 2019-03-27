package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.array_modifier;

public interface IArraySizeModifierVisitor<T> {
	T visitArraySizeFromExpression(ArraySizeFromExpressionCtx ctx);
	T visitArraySizeFromType(ArraySizeFromTypeModCtx ctx);
}
