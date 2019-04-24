package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;

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

	public Type setBaseType(BaseType baseType) {
		this.baseType = baseType;
		return this;
	}

	public boolean isReferenceType() {
		return referenceType;
	}

	public Type setReferenceType(boolean referenceType) {
		this.referenceType = referenceType;
		return this;
	}

	public List<AbsArrayModifier> getArrayModifiers() {
		return arrayModifiers;
	}

	public Type addArrayModifier(AbsArrayModifier arrayModifier) {
		getArrayModifiers().add(arrayModifier);
		return this;
	}

	@Override
	public Type deepClone() {
		Type clone = new Type();
		clone.baseType = baseType.deepClone();
		clone.referenceType = referenceType;
		arrayModifiers.stream()
				.forEachOrdered(m -> clone.arrayModifiers.add((AbsArrayModifier<?>) m.deepClone()));
		return clone;
	}
}
