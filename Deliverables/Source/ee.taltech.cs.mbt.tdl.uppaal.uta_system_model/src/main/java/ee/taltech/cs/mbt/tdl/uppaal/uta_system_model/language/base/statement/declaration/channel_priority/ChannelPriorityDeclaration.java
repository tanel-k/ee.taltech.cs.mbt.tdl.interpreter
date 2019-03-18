package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ChannelPriorityDeclaration extends AbsDeclarationStatement {
	private List<ChannelRefList> priorityList;

	public ChannelPriorityDeclaration() {
		this.priorityList = new LinkedList<>();
	}

	public List<ChannelRefList> getPriorityList() {
		return priorityList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPriorityList());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChannelPriorityDeclaration))
			return false;
		ChannelPriorityDeclaration other = (ChannelPriorityDeclaration) obj;
		return Objects.equals(other.priorityList, this.priorityList);
	}
}
