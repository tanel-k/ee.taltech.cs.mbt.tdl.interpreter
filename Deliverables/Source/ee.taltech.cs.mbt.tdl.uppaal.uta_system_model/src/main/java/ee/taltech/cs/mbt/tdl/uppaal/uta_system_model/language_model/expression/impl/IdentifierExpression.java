package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsLeafExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

import java.util.Objects;

/**
 * Represents a simple identifier reference expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ID
 *             |  ...
 * </pre>
 */
public class IdentifierExpression extends AbsLeafExprNode {
	public static IdentifierExpression of(String identifier) {
		return new IdentifierExpression(Identifier.of(identifier));
	}

	private Identifier identifier;

	private IdentifierExpression(Identifier identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return The referenced identifier.
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public IdentifierExpression deepClone() {
		return this; // singleton
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitIdentifierExpr(this);
	}
}