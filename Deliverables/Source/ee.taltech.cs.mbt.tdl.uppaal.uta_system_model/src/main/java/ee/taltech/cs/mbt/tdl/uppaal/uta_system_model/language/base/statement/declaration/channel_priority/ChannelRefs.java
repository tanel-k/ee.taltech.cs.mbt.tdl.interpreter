package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference.AbsChannelRef;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ChannelRefs implements Iterable<AbsChannelRef> {
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
		if (!(obj instanceof ChannelRefs))
			return false;
		ChannelRefs other = (ChannelRefs) obj;
		return Objects.equals(other.channelRefs, this.channelRefs);
	}
}
