package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;

public abstract class AbsLoopStatement extends AbsStatement {
	private AbsStatement body;

	public AbsStatement getBody() {
		return body;
	}

	public void setBody(AbsStatement body) {
		this.body = body;
	}
}
