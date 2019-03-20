package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

public class IterationLoop<LoopVarTypeIdentifier extends AbsTypeIdentifier> extends AbsLoopStatement {
	private IdentifierName loopVariable;
	private Type<LoopVarTypeIdentifier> iteratedType;

	public IdentifierName getLoopVariable() {
		return loopVariable;
	}

	public void setLoopVariable(IdentifierName loopVariable) {
		this.loopVariable = loopVariable;
	}

	public Type<LoopVarTypeIdentifier> getIteratedType() {
		return iteratedType;
	}

	public void setIteratedType(Type<LoopVarTypeIdentifier> iteratedType) {
		this.iteratedType = iteratedType;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitIteration(this);
	}
}
