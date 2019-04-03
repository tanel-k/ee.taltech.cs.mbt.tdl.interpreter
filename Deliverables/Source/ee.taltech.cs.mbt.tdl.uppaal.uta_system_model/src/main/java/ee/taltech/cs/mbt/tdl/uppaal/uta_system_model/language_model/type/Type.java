package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.AbsArrayModifier;

import java.util.LinkedList;
import java.util.List;

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
 */
public class Type implements IDeepCloneable<Type> {
	public static Type newInstance(BaseType baseType) {
		Type type = new Type();
		type.setBaseType(baseType);
		return type;
	}

	private BaseType baseType;
	private boolean referenceType;
	private List<AbsArrayModifier> arrayModifiers = new LinkedList<>();

	public Type() { }

	public BaseType getBaseType() {
		return baseType;
	}

	public void setBaseType(BaseType baseType) {
		this.baseType = baseType;
	}

	public boolean isReferenceType() {
		return referenceType;
	}

	public void setReferenceType(boolean referenceType) {
		this.referenceType = referenceType;
	}

	public List<AbsArrayModifier> getArrayModifiers() {
		return arrayModifiers;
	}

	@Override
	public Type deepClone() {
		Type clone = new Type();
		clone.setBaseType(getBaseType().deepClone());
		clone.setReferenceType(isReferenceType());
		getArrayModifiers().stream()
				.map(AbsArrayModifier::deepClone)
				.forEach(clone.getArrayModifiers()::add);
		return clone;
	}
}
