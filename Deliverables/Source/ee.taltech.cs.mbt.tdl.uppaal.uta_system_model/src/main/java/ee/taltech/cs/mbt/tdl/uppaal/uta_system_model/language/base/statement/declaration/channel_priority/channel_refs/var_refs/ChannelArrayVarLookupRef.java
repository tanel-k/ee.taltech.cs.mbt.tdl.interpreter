package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.var_refs;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.Objects;

public class ChannelArrayVarLookupRef<VarRefType extends AbsChannelVarRef> extends AbsChannelVarRef {
	private VarRefType channelRef;
	private AbsExpression lookupExpression;

	public VarRefType getChannelRef() {
		return channelRef;
	}

	public void setChannelRef(VarRefType channelRef) {
		this.channelRef = channelRef;
	}

	public AbsExpression getLookupExpression() {
		return lookupExpression;
	}

	public void setLookupExpression(AbsExpression lookupExpression) {
		this.lookupExpression = lookupExpression;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getChannelRef(), getLookupExpression());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChannelArrayVarLookupRef))
			return false;
		ChannelArrayVarLookupRef other = (ChannelArrayVarLookupRef) obj;
		return Objects.equals(other.channelRef, this.channelRef)
			&& Objects.equals(other.lookupExpression, this.lookupExpression);
	}
}
