package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

/**
 * Represents a variable declaration.<br/>
 * A variable can be declared with an initializing expression.<br/>
 * The initializing expression can be structured (i.e. an array or struct initializer)
 * or a flat expression.<br/>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * VariableDecl ::= Type VariableID (',' VariableID)* ';'
 * VariableID   ::= ID ArrayDecl* [ '=' Initialiser ]
 * Initialiser  ::= Expression
 *               |  '{' Initialiser (',' Initialiser)* '}'
 * </pre>
 * Examples:<br/>
 * <ul>
 *   <li><i>const int a = 1;</i></li>
 *   <li><i>int a[2][3] = { { 1, 2, 3 }, { 4, 5, 6} };</i></li>
 * </ul>
 * Note that the language allows variable declarations for a type to be grouped together.<br/>
 * This class represents a single non-grouped variable declaration.
 */
public class VariableDeclaration extends AbsVariableDeclaration {
	private Type type;
	private Identifier identifier;
	private AbsVariableInitializer initializer;

	public Type getType() {
		return type;
	}

	public VariableDeclaration setType(Type type) {
		this.type = type;
		return this;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public VariableDeclaration setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
	}

	public AbsVariableInitializer getInitializer() {
		return initializer;
	}

	public VariableDeclaration setInitializer(AbsVariableInitializer initializer) {
		this.initializer = initializer;
		return this;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitVariableDeclaration(this);
	}

	@Override
	public VariableDeclaration deepClone() {
		VariableDeclaration clone = new VariableDeclaration();
		clone.type = type.deepClone();
		clone.identifier = identifier.deepClone();
		clone.initializer = initializer != null
				? initializer.deepClone()
				: null;
		return clone;
	}
}
