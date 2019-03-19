package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.traversal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.DefaultChannelPriority;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.var_refs.ChannelArrayVarLookupRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.var_refs.ChannelVarIdentifierRef;

public interface IChannelRefExpressionVisitor {
	void visitChannelArrayVarLookupRef(ChannelArrayVarLookupRef channelArrayVarLookupRef);
	void visitChannelVarIdentifierRef(ChannelVarIdentifierRef channelVarIdentifierRef);
	void visitDefaultChannelPriority(DefaultChannelPriority defaultChannelPriority);
}
