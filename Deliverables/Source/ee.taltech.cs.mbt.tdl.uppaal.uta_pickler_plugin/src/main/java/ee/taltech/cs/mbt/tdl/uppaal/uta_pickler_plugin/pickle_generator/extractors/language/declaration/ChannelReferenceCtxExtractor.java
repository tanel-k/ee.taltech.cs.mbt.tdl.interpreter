package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelArrayLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.ChannelIdentifierReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.DefaultChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.ArrayVariableLookup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IChannelReferenceVisitor;

import java.util.Collection;
import java.util.Set;

public class ChannelReferenceCtxExtractor implements IPicklerContextExtractor<AbsChannelReference>,
		IChannelReferenceVisitor<ContextBuilder> {
	public static ChannelReferenceCtxExtractor getInstance() {
		return new ChannelReferenceCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private ChannelReferenceCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsChannelReference channelReference) {
		requiredClasses.add(channelReference.getClass());
		return channelReference.accept(this);
	}

	@Override
	public ContextBuilder visitChannelArrayLookup(ChannelArrayLookup ref) {
		requiredClasses.add(ArrayVariableLookup.class);
		requiredClasses.add(Identifier.class);
		String arrayName = ref.getArrayVariableLookup().getIdentifier().toString();
		Collection<ContextBuilder> lookupExprCtxs = ExpressionCtxExtractor.getInstance()
				.extract(ref.getArrayVariableLookup().getLookupExpressions(), requiredClasses);
		return ContextBuilder.newBuilder("arrayLookup")
				.put("arrayName", arrayName)
				.put("lookupExpressions", lookupExprCtxs);
	}

	@Override
	public ContextBuilder visitChannelIdentifierReference(ChannelIdentifierReference ref) {
		requiredClasses.add(Identifier.class);
		return ContextBuilder.newBuilder("channelIdentifier")
				.put("identifier", ref.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitDefaultChannelReference(DefaultChannelReference ref) {
		return ContextBuilder.newBuilder("defaultPriority");
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
