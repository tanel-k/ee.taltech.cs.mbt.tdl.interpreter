package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IStatementVisitor;

/**
 * Represents the UPPAAL while (...) {...} loop.<br/>
 * Syntax:<br/>
 * <pre>
 * WhileLoop ::= 'while' '(' Expression ')' Statement
 * </pre>
 */
public class WhileLoop extends AbsConditionalLoopStatement {
	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitWhileStatement(this);
	}
}
