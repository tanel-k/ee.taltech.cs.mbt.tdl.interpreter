package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.visitation.IArrayModifierVisitor;

/**
 * An {@link AbsArrayModifier} that specifies the array size
 * using a scalar set type.
 */
public class SizeTypeArrayModifier extends AbsArrayModifier<Type> {
	@Override
	public void accept(IArrayModifierVisitor arrayModifierVisitor) {
		arrayModifierVisitor.visitSizeTypeModifier(this);
	}
}
