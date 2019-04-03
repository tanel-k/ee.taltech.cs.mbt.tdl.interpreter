package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

import java.util.LinkedList;
import java.util.List;

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
public class StructTypeId extends AbsTypeId {
	private List<AbsFieldDeclaration> fieldDeclarations = new LinkedList<>();

	public List<AbsFieldDeclaration> getFieldDeclarations() {
		return fieldDeclarations;
	}

	@Override
	public StructTypeId deepClone() {
		StructTypeId clone = new StructTypeId();
		clone.getFieldDeclarations()
				.stream()
				.map(AbsFieldDeclaration::deepClone)
				.forEach(clone.getFieldDeclarations()::add);
		return clone;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitStructTypeIdentifier(this);
	}
}
