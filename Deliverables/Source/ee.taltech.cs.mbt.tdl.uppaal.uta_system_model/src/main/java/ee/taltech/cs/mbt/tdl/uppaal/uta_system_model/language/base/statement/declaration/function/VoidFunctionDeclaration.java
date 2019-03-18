package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

public class VoidFunctionDeclaration extends AbsFunctionDeclaration {
	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitVoidFunction(this);
	}
}
