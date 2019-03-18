package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

public class IterationLoop<LoopVarTypeIdentifier extends AbsTypeIdentifier> extends AbsLoopStatement {
	private Identifier loopVariable;
	private Type<LoopVarTypeIdentifier> iteratedType;

	public Identifier getLoopVariable() {
		return loopVariable;
	}

	public void setLoopVariable(Identifier loopVariable) {
		this.loopVariable = loopVariable;
	}

	public Type<LoopVarTypeIdentifier> getIteratedType() {
		return iteratedType;
	}

	public void setIteratedType(Type<LoopVarTypeIdentifier> iteratedType) {
		this.iteratedType = iteratedType;
	}
}
