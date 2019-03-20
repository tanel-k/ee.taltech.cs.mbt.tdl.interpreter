package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;

public class DefaultChannelPriorityRef extends AbsChannelRef {
	public static final DefaultChannelPriorityRef INSTANCE = new DefaultChannelPriorityRef();

	private DefaultChannelPriorityRef() {}

	@Override
	public void accept(IChannelRefVisitor visitor) {
		visitor.visitDefaultChannelPriorityRef(this);
	}
}
