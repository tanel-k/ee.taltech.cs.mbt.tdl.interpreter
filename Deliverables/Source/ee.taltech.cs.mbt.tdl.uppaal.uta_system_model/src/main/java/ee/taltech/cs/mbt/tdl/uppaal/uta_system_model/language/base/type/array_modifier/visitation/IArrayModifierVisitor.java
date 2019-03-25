package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.SizeTypeArrayModifier;

public interface IArrayModifierVisitor<T> {
	T visitSizeExpressionModifier(SizeExpressionArrayModifier modifier);
	T visitSizeTypeModifier(SizeTypeArrayModifier modifier);
}
