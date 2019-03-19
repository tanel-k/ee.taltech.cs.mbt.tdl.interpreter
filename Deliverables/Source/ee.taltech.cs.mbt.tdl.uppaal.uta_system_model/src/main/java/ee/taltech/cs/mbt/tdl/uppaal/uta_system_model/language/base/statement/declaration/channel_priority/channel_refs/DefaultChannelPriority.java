package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.traversal.IChannelRefExpressionVisitor;

public class DefaultChannelPriority extends AbsChannelRefExpression {
	public static final DefaultChannelPriority DEFAULT_PRIORITY_REF = new DefaultChannelPriority();

	private DefaultChannelPriority() { }

	@Override
	public void accept(IChannelRefExpressionVisitor visitor) {
		visitor.visitDefaultChannelPriority(this);
	}
}
