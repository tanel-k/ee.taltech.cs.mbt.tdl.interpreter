package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;

/**
 * Represents the UPPAAL do {...} while(...); loop.<br/>
 * Syntax:<br/>
 * <pre>
 * DoWhile ::= 'do' Statement 'while' '(' Expression ')' ';'
 * </pre>
 */
public class DoWhileLoop extends WhileLoop {
	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitDoWhile(this);
	}
}
