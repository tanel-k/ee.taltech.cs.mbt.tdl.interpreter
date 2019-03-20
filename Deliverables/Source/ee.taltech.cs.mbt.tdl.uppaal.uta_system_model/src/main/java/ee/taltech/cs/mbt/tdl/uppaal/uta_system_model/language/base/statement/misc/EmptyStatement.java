package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

/**
 * Represents a simple empty/no-op statement: ";".
 * Syntax:
 * <pre>
 * Statement       ::= ... | ';' | ...
 * </pre>
 */
public class EmptyStatement extends AbsStatement {
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitEmpty(this);
	}
}
