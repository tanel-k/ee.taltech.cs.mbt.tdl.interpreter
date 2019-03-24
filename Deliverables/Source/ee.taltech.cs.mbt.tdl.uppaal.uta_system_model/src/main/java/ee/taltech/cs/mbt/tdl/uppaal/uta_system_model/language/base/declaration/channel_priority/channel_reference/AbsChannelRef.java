package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;

/**
 * Represents a reference to a channel that can be used in a
 * channel priority declaration.<br/>
 */
public abstract class AbsChannelRef {
	public abstract <T> T accept(IChannelRefVisitor<T> visitor);
}
