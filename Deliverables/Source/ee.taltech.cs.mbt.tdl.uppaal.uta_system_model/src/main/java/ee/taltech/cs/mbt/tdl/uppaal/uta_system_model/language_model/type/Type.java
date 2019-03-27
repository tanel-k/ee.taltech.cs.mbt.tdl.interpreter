package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * There are 4 predefined types: int, bool, clock and chan.<br/>
 * Array and record types can be defined over these and other types.<br/>
 * </i>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * Type          ::= Prefix TypeId
 * Prefix        ::= 'urgent' | 'broadcast' | 'meta' | 'const'
 * TypeId        ::= ID | 'int' | 'clock' | 'chan' | 'bool'
 *                |  'int' '[' Expression ',' Expression ']'
 *                |  'scalar' '[' Expression ']'
 *                |  'struct' '{' FieldDecl (FieldDecl)* '}'
 * FieldDecl     ::= Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * ArrayDecl     ::= '[' Expression ']'
 *                |  '[' Type ']'
 * </pre>
 * @param <TypeIdentifier> @see {@link AbsTypeId}
 */
public class Type<TypeIdentifier extends AbsTypeId> {
	private ETypePrefix typePrefix = ETypePrefix.NONE;
	private boolean referenceType = false;
	private TypeIdentifier typeIdentifier;
	private List<AbsArrayModifier> arrayModifiers = new LinkedList<>();

	public Type() { }

	public Type<TypeIdentifier> clone() {
		Type<TypeIdentifier> type = new Type<>();
		type.typePrefix = this.typePrefix;
		type.typeIdentifier = this.typeIdentifier;
		type.referenceType = this.referenceType;
		type.arrayModifiers.addAll(this.arrayModifiers);
		return type;
	}

	public boolean isReferenceType() {
		return referenceType;
	}

	public void setReferenceType(boolean referenceType) {
		this.referenceType = referenceType;
	}

	public ETypePrefix getTypePrefix() {
		return typePrefix;
	}

	public void setTypePrefix(ETypePrefix typePrefix) {
		this.typePrefix = typePrefix;
	}

	public TypeIdentifier getTypeIdentifier() {
		return typeIdentifier;
	}

	public void setTypeIdentifier(TypeIdentifier typeIdentifier) {
		this.typeIdentifier = typeIdentifier;
	}

	public List<AbsArrayModifier> getArrayModifiers() {
		return arrayModifiers;
	}
}
