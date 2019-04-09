package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

public class DefaultChannelReference extends AbsChannelReference {
	public static DefaultChannelReference getInstance() {
		return INSTANCE;
	}

	private static final DefaultChannelReference INSTANCE = new DefaultChannelReference();

	private DefaultChannelReference() { }

	@Override
	public <T> T accept(IChannelReferenceVisitor<T> visitor) {
		return visitor.visitDefaultChannelReference(this);
	}
}
