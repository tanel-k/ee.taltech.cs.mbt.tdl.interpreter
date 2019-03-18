package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

public class ValueFunctionDeclaration<ValueTypeIdentifier extends AbsTypeIdentifier> extends AbsFunctionDeclaration {
	private Type<ValueTypeIdentifier> returnType;

	public Type<ValueTypeIdentifier> getReturnType() {
		return returnType;
	}

	public void setReturnType(Type<ValueTypeIdentifier> returnType) {
		this.returnType = returnType;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitValueFunctionDeclaration(this);
	}
}
