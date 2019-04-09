package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

/**
 * Parent class for type identifiers.<br/>
 * UPPAAL supports 4 base types: int, bool, clock and chan.<br/>
 * Array and record types can be defined over these and other types.<br/>
 * This class represents the `TypeId` production provided in the syntax description below:<br/>
 * <pre>
 * TypeId        ::= ID | 'int' | 'clock' | 'chan' | 'bool'
 *                |  'int' '[' Expression ',' Expression ']'
 *                |  'scalar' '[' Expression ']'
 *                |  'struct' '{' FieldDecl (FieldDecl)* '}'
 * FieldDecl     ::= Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * ArrayDecl     ::= '[' Expression ']'
 *                |  '[' Type ']'
 * </pre>
 */
public abstract class AbsTypeId implements IDeepCloneable<AbsTypeId> {
	@Override
	public abstract AbsTypeId deepClone();
	public abstract <T> T accept(ITypeIdentifierVisitor<T> visitor);
}
