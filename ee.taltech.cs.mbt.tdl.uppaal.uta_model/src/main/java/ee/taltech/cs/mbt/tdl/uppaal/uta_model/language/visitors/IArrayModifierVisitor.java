package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeTypeArrayModifier;

public interface IArrayModifierVisitor<T> {
	T visitSizeExpressionModifier(SizeExpressionArrayModifier modifier);
	T visitSizeTypeModifier(SizeTypeArrayModifier modifier);
}
