package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.channel_priority.channel_reference.AbsChannelReferenceExprCtx;

import java.util.LinkedList;
import java.util.List;

public class ChannelReferenceGroupCtx extends AbsCodeGenerationCtx {
	private List<AbsChannelReferenceExprCtx> channelReferenceExpressions = new LinkedList<>();

	public List<AbsChannelReferenceExprCtx> getChannelReferenceExpressions() {
		return channelReferenceExpressions;
	}
}
