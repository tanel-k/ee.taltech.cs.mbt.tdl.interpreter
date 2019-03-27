package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.AbsDeclarationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.IDeclarationCtxVisitor;

import java.util.LinkedList;
import java.util.List;

public class ChannelPriorityDeclCtx extends AbsDeclarationCtx {
	private List<ChannelReferenceGroupCtx> channelReferenceGroups = new LinkedList<>();

	public List<ChannelReferenceGroupCtx> getChannelReferenceGroups() {
		return channelReferenceGroups;
	}

	@Override
	public <T> T accept(IDeclarationCtxVisitor<T> visitor) {
		return visitor.visitChannelPriorityDeclaration(this);
	}
}
