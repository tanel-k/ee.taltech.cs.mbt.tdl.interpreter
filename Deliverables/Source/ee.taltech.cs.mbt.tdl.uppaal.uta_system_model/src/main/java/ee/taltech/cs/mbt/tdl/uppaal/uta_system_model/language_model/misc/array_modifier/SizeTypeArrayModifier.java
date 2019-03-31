package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IArrayModifierVisitor;

/**
 * An {@link AbsArrayModifier} that specifies the array size
 * using a scalar set type.
 */
public class SizeTypeArrayModifier extends AbsArrayModifier<BaseType> {
	@Override
	public <T> T accept(IArrayModifierVisitor<T> visitor) {
		return visitor.visitSizeTypeModifier(this);
	}

	@Override
	public SizeTypeArrayModifier deepClone() {
		SizeTypeArrayModifier clone = new SizeTypeArrayModifier();
		clone.setSizeSpecifier(getSizeSpecifier().deepClone());
		return clone;
	}
}
