package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

/**
 * Represents the UPPAAL while (...) {...} loop.<br/>
 * Syntax:<br/>
 * <pre>
 * WhileLoop ::= 'while' '(' Expression ')' Statement
 * </pre>
 */
public class WhileLoop extends AbsConditionalLoopStatement {
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitWhile(this);
	}
}
