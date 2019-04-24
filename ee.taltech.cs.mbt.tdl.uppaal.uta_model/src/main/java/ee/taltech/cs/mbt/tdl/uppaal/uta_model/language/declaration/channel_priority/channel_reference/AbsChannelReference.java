package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IChannelReferenceVisitor;

/**
 * Represents a reference to a channel that can be used in a
 * channel priority declaration.<br/>
 */
public abstract class AbsChannelReference implements IDeepCloneable<AbsChannelReference> {
	public abstract <T> T accept(IChannelReferenceVisitor<T> visitor);
}
