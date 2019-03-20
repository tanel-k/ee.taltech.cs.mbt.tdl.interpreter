package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

/**
 * Represents the UPPAAL do {...} while(...); loop.<br/>
 * Syntax:<br/>
 * <pre>
 * DoWhile ::= 'do' Statement 'while' '(' Expression ')' ';'
 * </pre>
 */
public class DoWhileLoop extends WhileLoop {
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitDoWhile(this);
	}
}
