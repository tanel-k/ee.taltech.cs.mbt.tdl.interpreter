package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.channel_reference;

/**
 * Represents a reference to a channel that can be used in a
 * channel priority declaration.<br/>
 */
public abstract class AbsChannelRef {
	public abstract <T> T accept(IChannelRefVisitor<T> visitor);
}
