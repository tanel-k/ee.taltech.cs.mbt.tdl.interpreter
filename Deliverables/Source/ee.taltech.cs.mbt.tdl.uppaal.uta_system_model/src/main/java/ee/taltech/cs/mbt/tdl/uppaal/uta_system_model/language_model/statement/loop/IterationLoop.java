package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IStatementVisitor;

/**
 * Represents an iteration loop over a type.<br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * A statement `for (ID : Type) Statement` will execute
 * `Statement` once for each value `ID` of the type `Type`.<br/>
 * The scope of `ID` is the inner statement `Statement`.<br/>
 * `Type` must be a bounded integer or a scalar set.
 * </i>
 */
public class IterationLoop extends AbsLoopStatement {
	private Identifier loopVariable;
	private BaseType iteratedType;

	public Identifier getLoopVariable() {
		return loopVariable;
	}

	public IterationLoop setLoopVariable(Identifier loopVariable) {
		this.loopVariable = loopVariable;
		return this;
	}

	public BaseType getIteratedType() {
		return iteratedType;
	}

	public IterationLoop setIteratedType(BaseType iteratedType) {
		this.iteratedType = iteratedType;
		return this;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitIterationStatement(this);
	}
}
