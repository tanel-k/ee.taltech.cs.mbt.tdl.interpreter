package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.ArrayVariableLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IChannelReferenceVisitor;

public class ChannelArrayLookup extends AbsChannelReference {
	private ArrayVariableLookup arrayVariableLookup;

	public ArrayVariableLookup getArrayVariableLookup() {
		return arrayVariableLookup;
	}

	public ChannelArrayLookup setArrayVariableLookup(ArrayVariableLookup arrayVariableLookup) {
		this.arrayVariableLookup = arrayVariableLookup;
		return this;
	}

	@Override
	public <T> T accept(IChannelReferenceVisitor<T> visitor) {
		return visitor.visitChannelArrayLookup(this);
	}

	@Override
	public ChannelArrayLookup deepClone() {
		ChannelArrayLookup clone = new ChannelArrayLookup();
		clone.arrayVariableLookup = arrayVariableLookup.deepClone();
		return clone;
	}
}
