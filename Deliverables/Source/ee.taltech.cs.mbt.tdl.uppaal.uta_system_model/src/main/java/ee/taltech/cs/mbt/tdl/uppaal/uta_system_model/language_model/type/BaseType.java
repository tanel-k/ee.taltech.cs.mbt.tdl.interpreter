package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;

public class BaseType implements IDeepCloneable<BaseType> {
	private AbsTypeId typeId;
	private ETypePrefix prefix = ETypePrefix.NONE;

	public AbsTypeId getTypeId() {
		return typeId;
	}

	public BaseType setTypeId(AbsTypeId typeId) {
		this.typeId = typeId;
		return this;
	}

	public ETypePrefix getPrefix() {
		return prefix;
	}

	public BaseType setPrefix(ETypePrefix prefix) {
		this.prefix = prefix;
		return this;
	}

	@Override
	public BaseType deepClone() {
		BaseType clone = new BaseType();
		clone.setTypeId(getTypeId().deepClone());
		clone.setPrefix(getPrefix());
		return clone;
	}
}
