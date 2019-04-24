package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;

/**
 * Represents a simple empty/no-op statement: ";".
 * Syntax:
 * <pre>
 * Statement       ::= ... | ';' | ...
 * </pre>
 */
public class EmptyStatement extends AbsStatement {
	public static EmptyStatement getInstance() {
		return INSTANCE;
	}

	private static final EmptyStatement INSTANCE = new EmptyStatement();

	private EmptyStatement() { }

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitEmptyStatement(this);
	}

	@Override
	public EmptyStatement deepClone() {
		return this;
	}
}
