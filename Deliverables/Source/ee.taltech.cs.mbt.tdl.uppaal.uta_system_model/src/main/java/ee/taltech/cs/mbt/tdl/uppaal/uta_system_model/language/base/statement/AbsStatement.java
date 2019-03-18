package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

public abstract class AbsStatement {
	public abstract void accept(IStatementVisitor visitor);
}
