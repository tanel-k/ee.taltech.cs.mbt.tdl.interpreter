package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

public class EmptyStatement extends AbsStatement {
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitEmpty(this);
	}
}
