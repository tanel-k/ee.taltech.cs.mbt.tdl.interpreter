package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

/**
 * Represents a statement in an UPPAAL function.<br/>
 * The syntax for statements is provided below:<br/>
 * <pre>
 * Block           ::= '{' Declarations Statement* '}'
 * Statement       ::= Block
 *                  | ';'
 *                  |  Expression ';'
 *                  |  ForLoop
 *                  |  Iteration
 *                  |  WhileLoop
 *                  |  DoWhileLoop
 *                  |  IfStatement
 *                  |  ReturnStatement
 * ForLoop         ::= 'for' '(' Expression ';' Expression ';' Expression ')' Statement
 * Iteration       ::= 'for' '(' ID ':' Type ')' Statement
 * WhileLoop       ::= 'while' '(' Expression ')' Statement
 * DoWhile         ::= 'do' Statement 'while' '(' Expression ')' ';'
 * IfStatement     ::= 'if' '(' Expression ')' Statement [ 'else' Statement ]
 * ReturnStatement ::= 'return' [ Expression ] ';'
 * </pre>
 */
public abstract class AbsStatement {
	public abstract void accept(IStatementVisitor visitor);
}
