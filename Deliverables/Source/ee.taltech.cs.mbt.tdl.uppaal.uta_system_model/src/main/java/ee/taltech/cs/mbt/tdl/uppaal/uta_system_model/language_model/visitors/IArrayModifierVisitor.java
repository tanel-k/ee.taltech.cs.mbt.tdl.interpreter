package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.SizeTypeArrayModifier;

public interface IArrayModifierVisitor<T> {
	T visitSizeExpressionModifier(SizeExpressionArrayModifier modifier);
	T visitSizeTypeModifier(SizeTypeArrayModifier modifier);
}
