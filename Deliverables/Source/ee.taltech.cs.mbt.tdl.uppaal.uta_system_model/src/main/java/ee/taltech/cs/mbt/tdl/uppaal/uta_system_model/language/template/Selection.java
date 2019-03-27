package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

public class Selection<TypeIdentifier extends AbsTypeId> {
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