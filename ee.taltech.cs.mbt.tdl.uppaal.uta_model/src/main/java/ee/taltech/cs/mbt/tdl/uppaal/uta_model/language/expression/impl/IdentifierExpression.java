package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsLeafExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents a simple identifier reference expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ID
 *             |  ...
 * </pre>
 */
public class IdentifierExpression extends AbsLeafExprNode {
	public static IdentifierExpression of(Identifier identifier) {
		return new IdentifierExpression(identifier);
	}

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

	public IdentifierExpression setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
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
