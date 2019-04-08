package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelIdentifierReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.DefaultChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

import java.util.Collection;

public class ChannelReferenceCtxExtractor implements IContextExtractor<AbsChannelReference>, IChannelReferenceVisitor<ContextBuilder> {
	public static ChannelReferenceCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final ChannelReferenceCtxExtractor INSTANCE = new ChannelReferenceCtxExtractor();

	private ChannelReferenceCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsChannelReference inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitChannelArrayLookup(ChannelArrayLookup ref) {
		Collection<ContextBuilder> arrayLookupCtxs = ExpressionCtxExtractor.getInstance()
				.extract(ref.getArrayVariableLookup().getLookupExpressions());
		return ContextBuilder.newBuilder("arrayLookup")
				.put("arrayName", ref.getArrayVariableLookup().getIdentifier().toString())
				.put("arrayLookups", arrayLookupCtxs);
	}

	@Override
	public ContextBuilder visitChannelIdentifierReference(ChannelIdentifierReference ref) {
		return ContextBuilder.newBuilder("channelIdentifier")
				.put("identifierValue", ref.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitDefaultChannelReference(DefaultChannelReference ref) {
		return ContextBuilder.newBuilder("defaultPriority");
	}
}
