package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.visitation.IArrayModifierVisitor;

public class SizeTypeArrayModifier extends AbsArrayModifier<Type> {
	@Override
	public void accept(IArrayModifierVisitor arrayModifierVisitor) {
		arrayModifierVisitor.visitSizeTypeModifier(this);
	}
}
