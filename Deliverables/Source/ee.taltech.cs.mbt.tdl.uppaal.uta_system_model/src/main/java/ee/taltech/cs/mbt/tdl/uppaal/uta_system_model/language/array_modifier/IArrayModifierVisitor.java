package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.array_modifier;

public interface IArrayModifierVisitor<T> {
	T visitSizeExpressionModifier(SizeExpressionArrayModifier modifier);
	T visitSizeTypeModifier(SizeTypeArrayModifier modifier);
}
