package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

public class Selection {
	private Identifier variableName;
	private Type selectType;

	public Identifier getVariableName() {
		return variableName;
	}

	public void setVariableName(Identifier variableName) {
		this.variableName = variableName;
	}

	public Type getSelectType() {
		return selectType;
	}

	public void setSelectType(Type selectType) {
		this.selectType = selectType;
	}
}
