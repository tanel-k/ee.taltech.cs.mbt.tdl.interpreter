package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;

public abstract class AbsChannelRef {
	public abstract void accept(IChannelRefVisitor visitor);
}
