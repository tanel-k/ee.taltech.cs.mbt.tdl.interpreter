package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

/**
 * Represents the declaration of a function with a return type.<br/>
 * Syntax:<br/>
 * <pre>
 * Function ::= Type ID '(' Parameters ')' Block
 *           |  ...
 * </pre>
 * @param <ValueTypeIdentifier> The identifier for the return type.
 * See {@link AbsTypeId}, {@link Type}.
 */
public class ValueFunctionDeclaration<ValueTypeIdentifier extends AbsTypeId> extends AbsFunctionDeclaration {
	private Type<ValueTypeIdentifier> returnType;

	public Type<ValueTypeIdentifier> getReturnType() {
		return returnType;
	}

	public void setReturnType(Type<ValueTypeIdentifier> returnType) {
		this.returnType = returnType;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitValueFunctionDeclaration(this);
	}
}
