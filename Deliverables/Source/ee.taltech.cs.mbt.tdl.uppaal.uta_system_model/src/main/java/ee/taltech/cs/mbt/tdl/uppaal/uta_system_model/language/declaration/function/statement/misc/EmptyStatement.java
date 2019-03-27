package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;

/**
 * Represents a simple empty/no-op statement: ";".
 * Syntax:
 * <pre>
 * Statement       ::= ... | ';' | ...
 * </pre>
 */
public class EmptyStatement extends AbsStatement {
	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitEmpty(this);
	}
}
