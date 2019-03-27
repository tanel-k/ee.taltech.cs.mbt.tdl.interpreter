package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;

/**
 * An {@link AbsArrayModifier} that specifies the array size
 * using a scalar set type.
 */
public class SizeTypeArrayModifier extends AbsArrayModifier<Type> {
	@Override
	public <T> T accept(IArrayModifierVisitor<T> visitor) {
		return visitor.visitSizeTypeModifier(this);
	}
}
