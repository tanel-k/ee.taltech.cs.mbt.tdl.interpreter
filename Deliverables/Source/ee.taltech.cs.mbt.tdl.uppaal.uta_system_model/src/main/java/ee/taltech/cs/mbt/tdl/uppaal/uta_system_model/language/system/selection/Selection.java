package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

public class Selection<TypeIdentifier extends AbsTypeIdentifier> {
	private IdentifierName variable;
	private Type<TypeIdentifier> selectionSourceType;

	public IdentifierName getVariable() {
		return variable;
	}

	public void setVariable(IdentifierName variable) {
		this.variable = variable;
	}

	public Type<TypeIdentifier> getSelectionSourceType() {
		return selectionSourceType;
	}

	public void setSelectionSourceType(Type<TypeIdentifier> selectionSourceType) {
		this.selectionSourceType = selectionSourceType;
	}
}