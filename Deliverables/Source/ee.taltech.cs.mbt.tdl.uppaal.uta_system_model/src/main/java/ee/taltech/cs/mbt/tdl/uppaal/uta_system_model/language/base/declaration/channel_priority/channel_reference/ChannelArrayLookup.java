package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.ArrayIdentifierLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;

/**
 * Represents a lookup in a channel array which can occur
 * in a channel priority declaration; f.ex: <i>d[2][3]</i>.<br/>
 * Wrapper around {@link ArrayIdentifierLookup}.
 */
public class ChannelArrayLookup extends AbsChannelRef {
	private ArrayIdentifierLookup arrayIdentifierLookup;

	public ArrayIdentifierLookup getArrayIdentifierLookup() {
		return arrayIdentifierLookup;
	}

	public void setArrayIdentifierLookup(ArrayIdentifierLookup arrayIdentifierLookup) {
		this.arrayIdentifierLookup = arrayIdentifierLookup;
	}

	@Override
	public void accept(IChannelRefVisitor visitor) {
		visitor.visitChannelArrayLookup(this);
	}
}
