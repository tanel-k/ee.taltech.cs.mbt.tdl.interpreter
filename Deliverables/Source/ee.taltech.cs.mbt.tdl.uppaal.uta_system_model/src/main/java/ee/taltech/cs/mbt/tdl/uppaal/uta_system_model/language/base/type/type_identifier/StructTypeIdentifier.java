package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.FieldDeclaration;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Identifies the UPPAAL record type.<br/>
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ...
 *                |  ...
 *                |  'struct' '{' FieldDecl (FieldDecl)* '}'
 * FieldDecl     ::= Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * ArrayDecl     ::= '[' Expression ']' |  '[' Type ']'
 * </pre>
 */
public class StructTypeIdentifier extends AbsTypeIdentifier {
	private List<FieldDeclaration> fieldDeclarations = new LinkedList<>();

	public List<FieldDeclaration> getFieldDeclarations() {
		return fieldDeclarations;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitStructTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFieldDeclarations());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StructTypeIdentifier))
			return false;
		StructTypeIdentifier other = (StructTypeIdentifier) obj;
		return Objects.equals(other.fieldDeclarations, this.fieldDeclarations);
	}
}
