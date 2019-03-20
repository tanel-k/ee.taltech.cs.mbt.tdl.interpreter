package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation.IDeclarationVisitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Global declarations can contain at most one channel priority declaration.<br/>
 * A channel priority declaration consists of a series of channel lists.<br/>
 * The less-than separator defines a higher level for channels sequenced on its right side.<br/>
 * The keyword 'default' represents channels that are not mentioned.<br/>
 * Note that channels listed in a channel priority declaration must be declared earlier.<br/>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * ChanPriority ::= 'chan' 'priority' (ChanExpr | 'default') ((',' | '<') (ChanExpr | 'default'))* ';'
 * ChanExpr ::= ID
 *           | ChanExpr '[' Expression ']'
 * </pre>
 */
public class ChannelPriorityDeclaration extends AbsDeclarationStatement implements Iterable<ChannelRefList> {
	private List<ChannelRefList> prioritySequence = new LinkedList<>();

	public List<ChannelRefList> getPrioritySequence() {
		return prioritySequence;
	}

	@Override
	public Iterator<ChannelRefList> iterator() {
		return prioritySequence.iterator();
	}

	@Override
	public void accept(IDeclarationVisitor declarationVisitor) {
		declarationVisitor.visitChannelPriorityDeclaration(this);
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
}
