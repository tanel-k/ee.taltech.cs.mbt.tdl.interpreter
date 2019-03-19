package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.template.transition.selection;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

public class Selection<TypeIdentifier extends AbsTypeIdentifier> {
	private Identifier variable;
	private Type<TypeIdentifier> selectionSourceType;

	public Identifier getVariable() {
		return variable;
	}

	public void setVariable(Identifier variable) {
		this.variable = variable;
	}

	public Type<TypeIdentifier> getSelectionSourceType() {
		return selectionSourceType;
	}

	public void setSelectionSourceType(Type<TypeIdentifier> selectionSourceType) {
		this.selectionSourceType = selectionSourceType;
	}
}