package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.channel_reference.AbsChannelRef;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a list of references to channels which are to be treated
 * as having the same priority level.<br/>
 */
public class ChannelRefList implements Iterable<AbsChannelRef> {
	private Set<AbsChannelRef> channelRefs = new LinkedHashSet<>();

	public Set<AbsChannelRef> getChannelRefs() {
		return channelRefs;
	}

	@Override
	public Iterator<AbsChannelRef> iterator() {
		return channelRefs.iterator();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getChannelRefs());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChannelRefList))
			return false;
		ChannelRefList other = (ChannelRefList) obj;
		return Objects.equals(other.channelRefs, this.channelRefs);
	}
}
