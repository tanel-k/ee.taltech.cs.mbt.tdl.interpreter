package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

/**
 * Represents an iteration loop over a type.<br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * A statement `for (ID : Type) Statement` will execute
 * `Statement` once for each value `ID` of the type `Type`.<br/>
 * The scope of `ID` is the inner statement `Statement`.<br/>
 * `Type` must be a bounded integer or a scalar set.
 * </i>
 * @param <LoopVarTypeIdentifier> Type identifier for the iteration variable.
 * See {@link AbsTypeId}, {@link Type}.
 */
public class IterationLoop<LoopVarTypeIdentifier extends AbsTypeId> extends AbsLoopStatement {
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
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitIteration(this);
	}
}
