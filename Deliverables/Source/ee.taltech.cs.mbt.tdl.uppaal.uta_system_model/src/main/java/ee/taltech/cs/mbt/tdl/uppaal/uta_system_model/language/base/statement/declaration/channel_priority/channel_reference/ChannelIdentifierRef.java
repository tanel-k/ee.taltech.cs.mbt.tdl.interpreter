package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference.visitation.IChannelRefVisitor;

public class ChannelIdentifierRef extends AbsChannelRef {
	private IdentifierName identifierName;

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public void accept(IChannelRefVisitor visitor) {
		visitor.visitChannelIdentifierRef(this);
	}
}
