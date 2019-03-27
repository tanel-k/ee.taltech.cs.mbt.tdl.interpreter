package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.ArrayVariableLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

public class ChannelArrayLookup extends AbsChannelReference {
	private ArrayVariableLookup arrayVariableLookup;

	public ArrayVariableLookup getArrayVariableLookup() {
		return arrayVariableLookup;
	}

	public void setArrayVariableLookup(ArrayVariableLookup arrayVariableLookup) {
		this.arrayVariableLookup = arrayVariableLookup;
	}

	@Override
	public <T> T accept(IChannelReferenceVisitor<T> visitor) {
		return visitor.visitChannelArrayLookup(this);
	}
}
