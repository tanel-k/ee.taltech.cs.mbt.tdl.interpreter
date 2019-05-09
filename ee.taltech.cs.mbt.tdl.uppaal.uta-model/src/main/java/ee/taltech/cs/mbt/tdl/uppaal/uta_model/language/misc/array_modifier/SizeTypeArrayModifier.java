package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IArrayModifierVisitor;

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
