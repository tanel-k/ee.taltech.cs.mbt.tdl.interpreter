package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

/**
 * Represents a reference to a channel that can be used in a
 * channel priority declaration.<br/>
 */
public abstract class AbsChannelReference {
	public abstract <T> T accept(IChannelReferenceVisitor<T> visitor);
}
