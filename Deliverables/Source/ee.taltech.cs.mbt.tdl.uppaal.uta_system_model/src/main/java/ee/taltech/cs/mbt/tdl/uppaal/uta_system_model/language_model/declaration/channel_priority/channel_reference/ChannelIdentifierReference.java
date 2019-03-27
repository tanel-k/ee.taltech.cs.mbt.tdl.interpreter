package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

public class ChannelIdentifierReference extends AbsChannelReference {
	@Override
	public <T> T accept(IChannelReferenceVisitor<T> visitor) {
		return visitor.visitChannelIdentifierReference(this);
	}
}
