package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelReferenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

import java.util.LinkedList;
import java.util.List;

public class ChannelReferenceGroupCtx extends AbsCodeGenerationCtx {
	private List<ChannelReferenceContext> channelReferenceExpressions = new LinkedList<>();

	public List<ChannelReferenceContext> getChannelReferenceExpressions() {
		return channelReferenceExpressions;
	}
}
