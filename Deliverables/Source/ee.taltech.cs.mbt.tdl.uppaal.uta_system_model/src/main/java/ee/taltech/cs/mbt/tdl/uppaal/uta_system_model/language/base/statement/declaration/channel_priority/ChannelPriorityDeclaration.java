package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ChannelPriorityDeclaration extends AbsDeclarationStatement {
	private List<ChannelRefSequence> prioritySequence = new LinkedList<>();

	public List<ChannelRefSequence> getPrioritySequence() {
		return prioritySequence;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPrioritySequence());
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
		return Objects.equals(other.prioritySequence, this.prioritySequence);
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitChannelPriorityDeclaration(this);
	}
}
