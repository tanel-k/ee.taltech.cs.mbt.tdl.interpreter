package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.AbsStatement;

/**
 * Represents the set of loop statements available in UPPAAL.<br/>
 * Syntax:<br/>
 * <pre>
 * Block           ::= '{' Declarations Statement* '}'
 * Statement       ::= Block
 *                  | ...
 *                  |  ForLoop
 *                  |  Iteration
 *                  |  WhileLoop
 *                  |  DoWhileLoop
 *                  |  ...
 * ForLoop         ::= 'for' '(' Expression ';' Expression ';' Expression ')' Statement
 * Iteration       ::= 'for' '(' ID ':' Type ')' Statement
 * WhileLoop       ::= 'while' '(' Expression ')' Statement
 * DoWhile         ::= 'do' Statement 'while' '(' Expression ')' ';'
 * </pre>
 */
public abstract class AbsLoopStatement extends AbsStatement {
	private AbsStatement statement;

	public AbsStatement getStatement() {
		return statement;
	}

	public void setStatement(AbsStatement statement) {
		this.statement = statement;
	}
}
