package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;

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
public abstract class AbsStatement implements IDeepCloneable<AbsStatement> {
	public abstract <T> T accept(IStatementVisitor<T> visitor);
}
