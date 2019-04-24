package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;

public class Selection implements IDeepCloneable<Selection> {
	private Identifier variableName;
	private BaseType selectType;

	public Identifier getVariableName() {
		return variableName;
	}

	public Selection setVariableName(Identifier variableName) {
		this.variableName = variableName;
		return this;
	}

	public BaseType getSelectType() {
		return selectType;
	}

	public Selection setSelectType(BaseType selectType) {
		this.selectType = selectType;
		return this;
	}

	@Override
	public Selection deepClone() {
		Selection clone = new Selection();
		clone.variableName = variableName.deepClone();
		clone.selectType = selectType.deepClone();
		return clone;
	}
}
