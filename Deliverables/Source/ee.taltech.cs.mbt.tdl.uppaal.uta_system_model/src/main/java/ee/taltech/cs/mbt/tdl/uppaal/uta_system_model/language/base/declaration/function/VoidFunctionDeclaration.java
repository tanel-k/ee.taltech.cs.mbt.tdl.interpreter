package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation.IDeclarationVisitor;

/**
 * Represents the declaration of a function with no return type.<br/>
 * Syntax:<br/>
 * <pre>
 * Function ::= ...
 *           |  'void' ID '(' Parameters ')' Block
 * </pre>
 */
public class VoidFunctionDeclaration extends AbsFunctionDeclaration {
	@Override
	public void accept(IDeclarationVisitor declarationVisitor) {
		declarationVisitor.visitVoidFunctionDeclaration(this);
	}
}
