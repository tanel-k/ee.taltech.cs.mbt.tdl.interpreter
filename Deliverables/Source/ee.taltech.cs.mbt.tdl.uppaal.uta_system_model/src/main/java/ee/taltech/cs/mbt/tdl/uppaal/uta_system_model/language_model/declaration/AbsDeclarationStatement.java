package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

/**
 * Adapted from UPPAAL documentation:<br/>
 * Declarations are either global or local to a template.<br/>
 * Declarations can contain declarations of clocks, bounded integers, channels, arrays, records, and types.<br/>
 * The syntax is described by the grammar for <i>Declarations</i>:
 * <pre>
 * Declarations  ::= (VariableDecl | TypeDecl | Function | ChanPriority)*
 * VariableDecl  ::= Type VariableID (',' VariableID)* ';'
 * VariableID    ::= ID ArrayDecl* [ '=' Initialiser ]
 * Initialiser   ::= Expression
 *                |  '{' Initialiser (',' Initialiser)* '}'
 * TypeDecl     ::= 'typedef' Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * </pre>
 * <br/>
 * Note also, that in a block statement (the body of a function), declarations may occur before any statements do.
 */
public abstract class AbsDeclarationStatement {
	public abstract <T> T accept(IDeclarationVisitor<T> visitor);
}
