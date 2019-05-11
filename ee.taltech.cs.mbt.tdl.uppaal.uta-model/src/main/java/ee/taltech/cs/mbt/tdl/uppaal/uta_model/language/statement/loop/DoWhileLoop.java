package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;

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
		return visitor.visitDoWhileStatement(this);
	}

	@Override
	public DoWhileLoop deepClone() {
		DoWhileLoop clone = new DoWhileLoop();
		clone.setCondition(getCondition().deepClone());
		clone.setStatement(getStatement().deepClone());
		return clone;
	}
}
