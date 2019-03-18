package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_refs.var_refs;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;

import java.util.Objects;

public class ChannelVarIdentifierRef extends AbsChannelVarRef {
	private Identifier identifier;

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identifier);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChannelVarIdentifierRef))
			return false;
		ChannelVarIdentifierRef other = (ChannelVarIdentifierRef) obj;
		return Objects.equals(other.identifier, this.identifier);
	}
}
