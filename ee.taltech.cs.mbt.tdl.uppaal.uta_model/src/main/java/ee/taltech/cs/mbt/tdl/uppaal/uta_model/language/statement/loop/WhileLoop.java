package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;

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

	@Override
	public WhileLoop deepClone() {
		WhileLoop clone = new WhileLoop();
		clone.setCondition(getCondition().deepClone());
		clone.setStatement(getStatement().deepClone());
		return clone;
	}
}
