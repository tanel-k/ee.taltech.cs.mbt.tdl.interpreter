package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a list of references to channels which are to be treated
 * as having the same priority level.<br/>
 */
public class ChannelReferenceGroup implements Iterable<AbsChannelReference>, IDeepCloneable<ChannelReferenceGroup> {
	private List<AbsChannelReference> channelReferences = new LinkedList<>();

	public List<AbsChannelReference> getChannelReferences() {
		return channelReferences;
	}

	public ChannelReferenceGroup addChannelReference(AbsChannelReference channelReference) {
		getChannelReferences().add(channelReference);
		return this;
	}

	@Override
	public Iterator<AbsChannelReference> iterator() {
		return channelReferences.iterator();
	}

	@Override
	public ChannelReferenceGroup deepClone() {
		ChannelReferenceGroup clone = new ChannelReferenceGroup();
		channelReferences.stream()
				.forEachOrdered(r -> clone.channelReferences.add(r.deepClone()));
		return clone;
	}
}
