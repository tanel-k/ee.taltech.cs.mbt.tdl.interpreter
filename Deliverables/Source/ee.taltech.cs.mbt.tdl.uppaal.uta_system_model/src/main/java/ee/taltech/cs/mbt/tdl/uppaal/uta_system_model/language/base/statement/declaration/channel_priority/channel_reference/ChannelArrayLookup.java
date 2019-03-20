package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.ArrayIdentifierLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;

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
