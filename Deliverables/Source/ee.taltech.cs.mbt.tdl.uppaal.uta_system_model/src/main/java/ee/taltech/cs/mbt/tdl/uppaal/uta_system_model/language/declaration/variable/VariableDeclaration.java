package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.initializer.AbsInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

import java.util.Objects;

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
 * @param <TypeIdentifier> See {@link AbsTypeId}
 * @param <InitializerType> See {@link AbsInitializer}
 */
public class VariableDeclaration<
		TypeIdentifier extends AbsTypeId, InitializerType extends AbsInitializer
	> extends AbsDeclarationStatement
{
	private Type<TypeIdentifier> type;
	private IdentifierName identifierName;
	private InitializerType initializer;

	public Type<TypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<TypeIdentifier> type) {
		this.type = type;
	}

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	public InitializerType getInitializer() {
		return initializer;
	}

	public void setInitializer(InitializerType initializer) {
		this.initializer = initializer;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitVariableDeclaration(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getType(),
			getIdentifierName(),
			getInitializer()
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VariableDeclaration))
			return false;
		VariableDeclaration other = (VariableDeclaration) obj;
		return Objects.equals(other.type, this.type)
			&& Objects.equals(other.identifierName, this.identifierName)
			&& Objects.equals(other.initializer, this.initializer);
	}
}
