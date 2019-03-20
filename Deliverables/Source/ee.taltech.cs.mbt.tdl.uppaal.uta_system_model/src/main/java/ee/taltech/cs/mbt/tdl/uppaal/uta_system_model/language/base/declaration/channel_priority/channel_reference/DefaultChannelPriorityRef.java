package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;

/**
 * Represents the priority level of all channels
 * not mentioned in a channel priority declaration (`default`).<br/>
 * Singleton.
 */
public class DefaultChannelPriorityRef extends AbsChannelRef {
	public static final DefaultChannelPriorityRef INSTANCE = new DefaultChannelPriorityRef();

	private DefaultChannelPriorityRef() {}

	@Override
	public void accept(IChannelRefVisitor visitor) {
		visitor.visitDefaultChannelPriorityRef(this);
	}
}
