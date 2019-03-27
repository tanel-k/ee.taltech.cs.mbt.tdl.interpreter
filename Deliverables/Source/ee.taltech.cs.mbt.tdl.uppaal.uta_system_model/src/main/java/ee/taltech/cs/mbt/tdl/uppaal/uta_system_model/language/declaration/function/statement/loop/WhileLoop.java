package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;

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
		return visitor.visitWhile(this);
	}
}
