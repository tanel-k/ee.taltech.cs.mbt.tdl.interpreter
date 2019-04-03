package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelIdentifierReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.DefaultChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

import java.util.Collection;

public class ChannelReferenceMapper implements IContextMapper<AbsChannelReference>, IChannelReferenceVisitor<ContextBuilder> {
	public static ChannelReferenceMapper getInstance() {
		return INSTANCE;
	}

	private static final ChannelReferenceMapper INSTANCE = new ChannelReferenceMapper();

	private ChannelReferenceMapper() { }

	@Override
	public ContextBuilder map(AbsChannelReference inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitChannelArrayLookup(ChannelArrayLookup ref) {
		Collection<ContextBuilder> arrayLookupCtxs = ExpressionMapper.getInstance()
				.map(ref.getArrayVariableLookup().getLookupExpressions());
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
