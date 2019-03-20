package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.ChannelIdentifierRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.DefaultChannelPriorityRef;

public class BaseChannelRefVisitor implements IChannelRefVisitor {
	@Override public void visitChannelArrayLookup(ChannelArrayLookup channelArrayLookup) { }
	@Override public void visitChannelIdentifierRef(ChannelIdentifierRef channelIdentifierRef) { }
	@Override public void visitDefaultChannelPriorityRef(DefaultChannelPriorityRef defaultChannelPriorityRef) { }
}
