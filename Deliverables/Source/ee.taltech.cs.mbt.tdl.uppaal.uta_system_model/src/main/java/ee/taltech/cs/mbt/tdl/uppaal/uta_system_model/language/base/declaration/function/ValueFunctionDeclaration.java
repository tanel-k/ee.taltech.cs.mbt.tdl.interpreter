package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

/**
 * Represents the declaration of a function with a return type.<br/>
 * Syntax:<br/>
 * <pre>
 * Function ::= Type ID '(' Parameters ')' Block
 *           |  ...
 * </pre>
 * @param <ValueTypeIdentifier> The identifier for the return type.
 * See {@link AbsTypeIdentifier}, {@link Type}.
 */
public class ValueFunctionDeclaration<ValueTypeIdentifier extends AbsTypeIdentifier> extends AbsFunctionDeclaration {
	private Type<ValueTypeIdentifier> returnType;

	public Type<ValueTypeIdentifier> getReturnType() {
		return returnType;
	}

	public void setReturnType(Type<ValueTypeIdentifier> returnType) {
		this.returnType = returnType;
	}

	@Override
	public void accept(IDeclarationVisitor declarationVisitor) {
		declarationVisitor.visitValueFunctionDeclaration(this);
	}
}
