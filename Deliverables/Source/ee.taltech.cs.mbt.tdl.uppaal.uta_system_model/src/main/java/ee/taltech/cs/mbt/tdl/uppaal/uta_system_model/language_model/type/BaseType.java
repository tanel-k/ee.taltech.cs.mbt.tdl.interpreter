package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;

public class BaseType implements IDeepCloneable<BaseType> {
	private AbsTypeId typeId;
	private ETypePrefix prefix = ETypePrefix.NONE;

	public AbsTypeId getTypeId() {
		return typeId;
	}

	public void setTypeId(AbsTypeId typeId) {
		this.typeId = typeId;
	}

	public ETypePrefix getPrefix() {
		return prefix;
	}

	public void setPrefix(ETypePrefix prefix) {
		this.prefix = prefix;
	}

	@Override
	public BaseType deepClone() {
		BaseType clone = new BaseType();
		clone.setTypeId(getTypeId().deepClone());
		clone.setPrefix(getPrefix());
		return clone;
	}
}
