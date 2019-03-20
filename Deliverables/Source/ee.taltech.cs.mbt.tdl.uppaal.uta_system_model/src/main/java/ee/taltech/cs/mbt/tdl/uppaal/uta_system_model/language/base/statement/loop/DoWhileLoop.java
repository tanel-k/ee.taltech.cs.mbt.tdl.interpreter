package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

public class DoWhileLoop extends WhileLoop {
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitDoWhile(this);
	}
}
