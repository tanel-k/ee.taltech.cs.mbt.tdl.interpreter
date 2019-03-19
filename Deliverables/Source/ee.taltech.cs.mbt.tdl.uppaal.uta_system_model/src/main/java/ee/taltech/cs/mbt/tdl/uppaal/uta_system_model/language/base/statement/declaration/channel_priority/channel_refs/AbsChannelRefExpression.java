package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.traversal.IChannelRefExpressionVisitor;

public abstract class AbsChannelRefExpression {
	public abstract void accept(IChannelRefExpressionVisitor visitor);
}
